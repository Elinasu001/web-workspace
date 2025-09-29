package com.kh.java.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;


@WebServlet("/myPage")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MyInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 내정보 조회란 뭘까
		// 디비서버와의 거리가 멀어질 수록 지연, 디비서버에 커넥션할 수록 과금 // 보안 적인 측면에는 디비와 멀어지는게 좋음
		
		/*
		 * [마이페이지 로직 설명]
		 * - 로그인한 사용자만 접근 가능해야 함 (인가 처리 필요)
		 * - 세션에서 로그인 정보를 확인한 후, DB에서 최신 정보를 다시 조회
		 * - 최신 정보로 갱신 후, 마이페이지 화면(my_page.jsp)으로 forward
		 * - 로그인 정보가 없거나 유효하지 않으면 result_page.jsp로 안내
		 */
		//사용자가 로그인할 때 한 번 userInfo를 세션에 넣어둠.
		//그 후 시간이 지나면서 DB에서 회원 정보가 변경될 수 있음.
		//항상 최신 정보를 보여주기
		
		// 1) 세션 객체 생성/가져오기
		HttpSession session = request.getSession();
		
		// 2) 세션에서 로그인된 사용자 정보 꺼내오기 (세션 스코프 userInfo)
		Member member = (Member)session.getAttribute("userInfo"); // 현재 로그인된 사용자의 정보가 갱신된 사용자 정보를 조회해서
		
		// 3) DB에서 최신 회원 정보 조회 (로그인 메서드 재활용)
		Member userInfo = new MemberService().login(member);
		
		// 4) 조회 성공 시 → 세션 정보 갱신 후, 마이페이지 이동
		if(userInfo != null) { // 만약, 데이터 값이 변동 되었다면, 값 갱신해서 변경된 내용 출력, 불러오는 도중에 로그인 했다면
			
			// 최신 회원 정보로 세션 갱신
			session.setAttribute("userInfo", userInfo);
			
			// 마이페이지 화면으로 포워딩
			request.getRequestDispatcher("/WEB-INF/views/member/my_page.jsp").forward(request, response);
			
		// 5) 조회 실패 시 → 로그인 필요 메시지와 함께 결과 페이지 이동	
		} else {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
