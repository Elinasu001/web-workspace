package com.kh.java.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.notice")// 앞에 뭘로 시작하든 상관 없고 .notice로 끝나면 무조건 나오게
public class NoticeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("뭐로 시작하든 notice로 끝나면 출동"); 
		
		String uri = request.getRequestURI();
		//System.out.println(uri); // /kh/select.notice url .notice로 찍은 게 나옴 
		String mapping  = uri.substring(uri.lastIndexOf("/") + 1 , uri.lastIndexOf("."));
		System.out.println(mapping);
		
		NoticeController nc = new NoticeController();
		
		String view = "";
		switch(mapping) {
		case "insert" : view = nc.insert(request, response); break;
		case "select" : view = nc.select(request, response); break;
		// default: view = "/WEB-INF/views/common/error.jsp" break;
		}
		
		// 오늘의 숙제 -> 내일까지
		// AJAX로 테이블에다가 INSERT, SLECT 구현해보기
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
