package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogoutController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그아웃을 구현해야함
		// 로그아웃이란 무엇일까?
		
		// 로그아웃은 session에 userInfo라는 속성을 null이 아니거나 비어있지 않을경우
		// 로그아웃은 session에 userInfo라는 속성을 null이거나 지우거나
		// 방법 1. : session 지우기
		// request.getSession().removeAttribute("userInfo");
		// 방법 2. : session 만료시키는 방법 ( == 무효화한다. ) , 다 날아가는 거니깐 주의해~
		request.getSession().invalidate();
		request.getSession().setAttribute("alertMsg", "로그아웃되었습니다~!!");
		// 응답데이터 => 웰텀파일
		// sendReirect();
		//System.out.println(request.getContextPath()); // /kh
		response.sendRedirect(request.getContextPath()); // /kh 나옴
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
