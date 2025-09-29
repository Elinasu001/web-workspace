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


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * <HttpServletRequest, HttpServletResponse>
		 * 
		 * - request : 서버로 요청 보낼 때의 정보(요청 시 전달값, 요청 전송방식, 사용자정보)
		 * - response : 요청에 대한 응답데이터를 만들 때 사용
		 * 
		 */
		
		// 절차
		// 1) GET? POST? => 요청 방식이 POST방식이라면 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달값이 있나? 없나? => POST 는 무조건해야함
		// request.getParameter("키값") : String
		// request.getParameterValue("키값") : String[]
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		//System.out.println(userId); // admin // 제대로 값이 안들어올 경우 null 이다
		//System.out.println(userPwd); // 1234
		
		// vo 생성 후 담아주세요
		// 3) 데이터 가공
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		// 4) 요청 처리
		Member loginMember = new MemberService().login(member);
		
		// service-dao-sql까지 갔다가 확인 해보기
		// 성공했을 경우 : 조회성공한 컬럼값을 필드에 담은 멤버객체 주소
		// 실패했을 경우 : null 값
		//System.out.println(loginMember); // 성공(값이 들어옴) 실패(null) 체크 후 다음으로 넘어가기
		
		// 5) 응답화면 지정
		// 스탭 1. request 속성에 출력할 값 추가 => setAttribute()
		// 스탭 2. RequestDispatcher => 뷰 지정
		// 스탭 3. RequestDispatcher이용해서 forward() 호출
		// 그럼 로그인된 정보는 로그아웃 전까지 유지 되어야 하니 
		// 1. 로그인된 사용자의 정보를 어딘가에 담아야된다.(application, session, request, page)
		// 여기서 어디로 담아야 할까? 
		/*
		 * 크다
		 * 1) application : 웹 애플리케이션 전역에서 사용 가능
		 * 					(일반 자바 클래스에서 값을 사용할 수 있음)
		 * 
		 * 2) session : 모든 JSP와 Servlet 에서 꺼내 쓸 수 있음
		 * 				단, session에 값이 지워지기 전까지
		 * 				세션 종료 시점 : 브라우저 종료, 서버 멈춤, 코드로 지움
		 * 				세션과 쿠키 (쿠키는 다음 수업에 배울 예정)
		 * 							
		 * 
		 * 3) request : 해당 request를 포워딩한 응답 JSP에서만 쓸 수 있음
		 * 				요청 부터 응답까지만 딱 쓸 수 있음
		 * 
		 * 4) page : 값을 담은 JSP에서만 쓸 수 있음
		 * 작다
		 * 
		 * => session, request를 많이 사용함
		 */
		
		// 로그인에 성공할 수 도있음 / 실패할 수 도있음
		// 2. 성공실패 여부에 따라서 응답 페이지 다르게 보내주기
		if(loginMember != null) {
			// 로그인 성공!!
			
			// 사용자의 정보를 앞단에 넘기기
			// 로그인한 회원의정보를 로그아웃하거나
			// 브라우저를 종료하기 전까지는 게속해서 유지학 사용할 것이기 때문에
			// session에 담기
			
			// 스탭 1. session의 Attribute로 사요자 정보 추가
			// session의 타입 : HttpSession
			// => 현재 요청 보내는 Client의 Session : request.getSession();
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", loginMember);
			
			// 스탭 2. RequestDispatcher get해오기
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			// index.jsp 인데 다른 파일로 대체 될 수 있음 index2.jsp 라던가… 
			// 이럴 경우, 이럴 때마다 loginController의 경로까지 같이 바꿔줘야 하는 번거로움이 있다.
			// => 포워딩 방식을 변경해보자 !
			
			// 2025-09-29
			// localhost:4000/kh
			// sendRedirect  : Client에게 URL을 다시 요청하게 함
			// response 객체를 이용
			// response.sendRedirect("/다시 요청 보낼 URL경로"); // login 붙어 있던게 사라짐 ! 
			session.setAttribute("alertMsg", "로그인에 성공 ~!!!!");
			response.sendRedirect(request.getContextPath());
			
			
			// 근데 ? 로그인 로그아웃 두개로 같이 나오면 안되니 header.jsp가서 조건문 처리 해주기
			
		} else {
			// 로그인 실패!! - 이페지 먼저 해보쟝
			
			// 로그인에 실패했습니다 변경 나머지는 고정
			// request는 응답하고 나면은 꺼짐
			request.setAttribute("msg", "로그인에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
