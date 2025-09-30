package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.MyRenamePolicy;
import com.kh.java.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/insert.board")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩 설정(utf-8)
		request.setCharacterEncoding("UTF-8");
		
		// 2) 값 뽑기
		//String title = request.getParameter("title");
		//String content = request.getParameter("contet");
		// form 태그 요청 시 multipart/form-date형식으로 전송한 경우
		// request.getParameter로는 값을 뽑아낼 수 없음
		
		// 스탭 0) 요청이 multipart 방식으로 왔는가 확인
		if(ServletFileUpload.isMultipartContent(request)) {
			// 스탭 1) 전송된 파일을 위한 작업
			// 1_1. 전송파일 용량 제한
			
			/*
			 * 단위 정리 
			 *
			 * bit x 8 => KByte => MByte => GByte => TByte => PByte
			 * 
			 * 10MegaByte 보다 큰파일 오릴 경우 예외 발생 일어남 (보통으 100mega이지만 일단 10mega...)
			 * 
			 */
			
			int maxSize = 10 * 1024  * 1024;
			
			// 1_2. 서버의 저장할 폴더 경로 알아내기 // webapp>resources>img
			// pageContext	: jsp 까지
			// HttpServletRequest : 포워딩 jsp 까지
			// HttpSession : 모든 jsp/servlet 브라우저 종료, 서버 멈춤, 코드지움까지
			// application == ServletContext : 프로젝트 전체 [v]
			// getRealPath() 호출해서 사용
			
			HttpSession session = request.getSession();
			// request.getServletContext();
			ServletContext application = session.getServletContext();
			String savePath = application.getRealPath("/resources/board_upfiles"); // 물리적 경로 얻기
			// System.out.println(savePath); // 저장 경로 =>  C:\javaKh\web-workspace\KHProject\src\main\webapp\resources\board_upfiles
			// 장점 : 동적으로 실제 경로 확인 , 서버환경에 관계없이 동작
			// 단점 : war파일 배포 시 파일이 사라질 수 있음
			// 하지만, 나중에 현시대 WS(Amazon Web Services) 같은 클라우드 스토리지 서비스 사용할 예정 (Servlet/JSP + AWS S3 업로드 구조_)
			
			// 스탭 2) 파일 업로드
			// 만약 파일을 똑같은 이름이 있다면 cos라이브러리가 이름을 바꿔준다.
			// a.jpg => a2.jpg => a3.jpg // 파일 넘버링 (좋은 방법은 아님...)
			
			/*
			 * HttpServletRequest
			 * => (이관)
			 * MultipartRequest 객체로 반환
			 * 
			 * [표현법]
			 * MultipartRequest multiRequest = new MultiRequest(request(원래 요청 객체(HttpServletRequest), savePath(저장경로), maxSize(용량제한), 인코딩("UTF-8"), 파일명을 수정해주는 객체(new DefaultFileRenamePolicy()));
			 * 
			 * Multipart객체를 생성하면 파일이 업로드!
			 * 
			 * 사용자가 올린 파일명은 이름을 바꿔서 업로드하는게 일반적인 관계
			 * 
			 * Q) 파일명 왜 바꾸나요?
			 * a) 똑같은 파일명 있을 수 있으니까
			 *    파일명에 한글 / 특수문자 / 공백문자 포함 경우 서버에 따라 문제가 발생하니깐
			 */
			// 파일 업로드 (resources/board_upfiles에 생성) // 정적페이지 : http://localhost:4000/kh/resources/board_upfiles/KHacademy_20250930171323_930.png
			// 근데 !! 파일 업로드 기능이니깐 원래는 따로 빼는게 좋음 !
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyRenamePolicy());
			
			// -- 파일 업로드 (인서트와 관계없음) --
			
			// 실질적으로 해야할 일 :BARD테이블에 INSERT 하기
			// 2) 값뽑기
			String title = multiRequest.getParameter("title");
			// System.out.println(title);
			String content = multiRequest.getParameter("content");
			String category = multiRequest.getParameter("category");
			Long userNo = ((Member)session.getAttribute("userInfo")).getUserNo();
			
			// 3) 데이터 가공
			Board board = new Board();
			board.setBoardTitle(title);
			board.setBoardContent(content);
			board.setCategory(category);
			board.setBoardWriter(String.valueOf(userNo));
			
			
			// 3_2) 첨부파일의 경우 => 선택적
			Attachment at = null;
			
			// 첨부파일의 유무를 파악 // enroll_form의 key값
			// System.out.println(multiRequest.getOriginalFileName("upfile"));
			// 첨부파일이 있다면 "원본파일명" / 없다면 null 값을 반환
			
			// 첨부파일이 있을 때만 
			if(multiRequest.getOriginalFileName("upfile") != null) {
				
				// 첨부파일이 있다 !! => vo 로 만들기
				at = new Attachment();
				
				// originName
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				
				// changeName
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				
				// filePath
				at.setFilePath("resources/board_upfiles");
			}
			
			
			// 4) 요청처리 Service 호출
			// service
			// insert 최소 한번 최대 두번
			// 실패 했을 때 하나의 트랜잭션
			new BoardService().insert(board, at);
			
		}
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
