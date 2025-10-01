package com.kh.java.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Category;


@WebServlet("/updateForm.board")
public class UpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateFormController() {
        super();
    }
    // 중복코드 어떻게 뺄까~~? 힌트 자바다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정하기 -> 원본 게시글 내용이 그대로 들어와야됨 -> 조회 -> select
		
		// 게시글 수정양식 보여주기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		// boardNo 있으면 
		
		// db조회 + attachment + category
		BoardService boardService = new BoardService();
		
		List<Category> category = boardService.selectCategory();
		
		Map<String, Object> map = boardService.selectBoard(boardNo);
		
		request.setAttribute("category", category);
		request.setAttribute("map", map);
		
		
		request.getRequestDispatcher("WEB-INF/views/board/update_form.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
