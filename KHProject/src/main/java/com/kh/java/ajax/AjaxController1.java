package com.kh.java.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax1.do")
public class AjaxController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet메소드 호출!");
		
		// 요청 시 전달값이 있을 때는? 값뽑기
		// request.getParameter
		String value = request.getParameter("value");
		//System.out.println("요청 시 전달값 : " + value);
		
		// 비즈니스 로직 처리
		// 잘했음 요청처리 잘됨
		
		// 응답
		// 응답할 값이 있다 == scope.setAttribute("키", "벨류");
		// 응답화면을 만들어낼 jsp 포워딩
		// 우리는 텍스트를 보낼 거니 우리 가 sevlet 맨 처음에 했던 응답 데이터 형식으로 해줘야된다 
		
		// 응답 데이터
		String responseData = "요청처리 성공!";
		
		// 1) 응답데이터 정보 설정 ★★★★★ 
		// 구분할 때는 ;
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 출력 스트림을 이용해서 응답 (출력 스트림)
		// 메소드 체이닝 이용
		response.getWriter().print(responseData);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
