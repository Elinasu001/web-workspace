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


@WebServlet("/members")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        // 1) 인코딩 설정
	        request.setCharacterEncoding("UTF-8");

	        // 2) request 객체로부터 요청 값 받기
	        String userId = request.getParameter("userId");
	        String userPwd = request.getParameter("userPwd");
	        String userName = request.getParameter("userName"); // ← 여기 오타 수정 (userPwd → userName)
	        String email = request.getParameter("email");

	        // 3) Member 객체에 담기
	        Member member = new Member();
	        member.setUserId(userId);
	        member.setUserPwd(userPwd);
	        member.setUserName(userName);
	        member.setEmail(email);

	        // 4) 서비스로 요청 처리
	        int result = new MemberService().signUp(member);

	        // 5) 결과 처리
	        if(result > 0) {
	            // 성공 → 메인 페이지로 이동
	        	HttpSession session = request.getSession();
	        	session.setAttribute("alertMsg", "회원가입 성공~!!");
	            response.sendRedirect(request.getContextPath());
	          
	            System.out.println("회원가입 성공");
	        } else {
	            // 실패 → 에러 메시지와 함께 결과 페이지
	            request.setAttribute("msg", "회원가입에 실패했습니다.");
	            request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
	            System.out.println("회원가입 실패");
	        }

	    } catch(Exception e) {
	        // 예상 못한 예외 발생 시
	        e.printStackTrace(); // 서버 콘솔에 로그 찍기
	        request.setAttribute("msg", "처리 중 오류가 발생했습니다");
	        request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
	    }
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
