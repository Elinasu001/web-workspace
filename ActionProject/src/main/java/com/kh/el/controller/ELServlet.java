package com.kh.el.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.el.model.vo.Person;

@WebServlet("/el.do")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ELServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 만약 서블릿에서 응답데이터가 존재한다면,
		// JSP로 포워딩할 때 request에 담아서 보내줬음 ! ==> Servlet 내장 객체 / Scope 객체
		// application / session/ request/ page
		
		/* 큰 순서
		 * 1. application scope : ServletContext
		 * 	  한 애플리케이션 당, 단 한 개 존재하는 객체
		 *    이 영역에 데이터를 담으면 애플리케이션 전역에서 사용 가능
		 * 
		 * 2. session scope : HttpSession [전역] 
		 *    하나의 브라우저 당, 한 개 존재하는 객체 (예 _ 로그인 정보 담아둠)
		 * 	  이 영역에 데이터를 담으면 JSP/Servlet 단에서 사용 가능
		 *    값이 한 번 담기면 서버를 멈추거나, 세션을 비우거나, 브라우저가 닫히기 전까지는 사용 가능
		 * 
		 * 3. request scope : HttpServletRequest
		 *    요청 및 응 답 시 매 번 생성되는 객체
		 * 	  이 영역에 데이터를 담으면 해당 request객체를 포워딩 받는 응답 JSP에서만 사용가능 (1회성)
		 * 
		 * 4. page scope : PageContext [페이지내]
		 * 	  JSP페이지 내에서만 사용 가능
		 * 
		 * => 위 객체들에 속성을 추가할 때는 .setAttribute("키", 벨류);
		 * 							  .getAttribute("키");
		 * 							  .removeAttribute("키");
		 */
		
		// 1) requestScope
		request.setAttribute("classRoom", "A강의장");
		request.setAttribute("student", new Person("홍길동", 15, "한양"));
		
		// 2) sessionScope
		HttpSession session = request.getSession();
		session.setAttribute("academy", "KH 아카데미");
		session.setAttribute("lecture", new Person("고길동", 40, "마포"));
		
		// 3) 응답 뷰 배정 -> 포워딩
		request.getRequestDispatcher("/WEB-INF/views/01_el.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
