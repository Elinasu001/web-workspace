package com.kh.java.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;

@WebServlet("/detail.image")
public class ImageDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// db select 2번
		// boardNo 필요
		//Long boardNo = Long.parseLong(request.getParameter("boardNo")); // 이렇게 사용한다면 ? 악의적인 사용자가 url 건드려서 NumberFormatExcetion 발생 할 수 있다.
		
		
		// 그래서 1. 문자열로 뽑고
		//String boardNo = request.getParameter("boardNo");
		// 빈문자열이거나 null이 아니거나
		/*
		if(boardNo != null || boardNo.isEmpty()) {
			Long num = Long.parseLong(boardNo);
		}
		*/
		// 원래라면 ... 세부적인 작업을 해줘야 되는데 일단, 넘기자.
		
		Long boardNo = Long.parseLong(request.getParameter("boardNo"));
		
		// [참고] ImageBoardDto는 못씀 why? 하나의 보드에 파일이 몇개인지 알 수 없기 때문 ... 
		// 들고가야되는것 대표 1, att 4 -> 5 그럼 대표는? 대표 1, 대표 1 -> 2
		// 즉, board 하나에 게시판 같이 들고 가야됨.
		Map<String, Object> map = new BoardService().selectImageDetail(boardNo);
		
		//System.out.println(map);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
