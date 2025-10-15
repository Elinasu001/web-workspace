package com.kh.java.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.member.model.service.MemberService;

@WebServlet(name = "CheckIdController", urlPatterns = { "/checkId" })
public class ChecKIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChecKIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 앞에서 AJAX 요청을 통해 넘어온 사용자가 입력한 문자열 데이터를
		// DB까지가서 KH_MEMBER테이블에 USER_ID컬럼에 있는 값인가 없는 값인가 조회를 해보고 
		// 조회결과를 다시 앞단으로 응답해주기
		
		String id = request.getParameter("id"); // 앞단 data의 속성명
		//System.out.println(id); // 5글자부터 요청 나옴
		
		// sql문을 어떻게 쓸까?, 어떻게 받아올까
		// 네이버는 NNNN(중복된 아이디 있는 것) NNNY(중복된 아이디 없는 것)
		
		String result = new MemberService().checkId(id);
		//sql까지 갔다온 후 확인
		//System.out.println(result);
		
		// 1) 응답데이터 무슨 데이터인지 인코딩
		response.setContentType("text.html; charset=UTF-8");
		
		// 2) 응답
		response.getWriter().print(result); // network preview
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
