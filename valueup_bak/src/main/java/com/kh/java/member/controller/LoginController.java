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
		
		// get? post? post 이면 인코딩 필요
		request.setCharacterEncoding("UTF-8");
		
		
		// 요청 전달 값이 있나? post 방식이면 무조건 request
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		System.out.println(userId);
		System.out.println(userPwd);
		
		// 데이터 가공
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		
		Member loginMember = new MemberService().login(member);
		
		
		if(loginMember != null) {
			
			// 스탭 1. session의 Attribute로 사요자 정보 추가
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", loginMember);
			
			// 스탭 2. RequestDispatcher get해오기
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			// 일단 실패 부터 체크 
			request.setAttribute("msg", "로그인에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
			
		}
		
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
