package com.kh.subway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.subway.model.service.SubwayService;
import com.kh.subway.model.vo.Subway;

@WebServlet("/orderList.sandwich")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L; // servlet 버전 없 할 경우 이력 관리 해야될 경우 하나씩 올릴 수 있음. github 올릴 경우나
       
    public OrderListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0) 요청전송방식이 뭐지 ?
		// GET ? / POST ? ==> a 태그 요청 == 100% Get 방식
		// GET 방식은 인코딩 작업 필요 없음
		
		// 1) 요청 시 전달값이 있는가?
		// a 태그든 form 태그로 보내든 중요하지 않다 URL이 어떤지를 잘 봐야 한다. ?value=value 이런식으로 들어 올 수 있다.
		// 1) 전달 값이 없으니 데이터 가공 => x
		
		// 2) 요청처리 -> Service단 호출
		// resultset... vo ... 알수 없음
		List<Subway> orderList = new SubwayService().findAll();
		
		//System.out.println(orderList);
		// 3) 응답결과 출력
		request.setAttribute("orders", orderList);
		
		// 4) 포워딩 [굳이 변수 만들지 않고 .forward 붙여서 사용]
		request.getRequestDispatcher("/views/list.jsp").forward(request, response); 
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
