package com.kh.java.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;


@WebServlet("/detail.board")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardDetailController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DB 2번 접근
		// KH_BOARD 게시글 내용 조회
		// KH_ATTACHMENT 첨부파일 조회
		// GET 방식
		
		// BOARD_NO
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		// 가공 x
		
		// 요청 처리 => 서비스단으로 boardNo 넘김
		// board + atthment 있을 수 있음.
		Map<String, Object> map = new BoardService().selectBoard(boardNo);
		
		String path = "";
		// 성공 / 실패
		if(map != null) {
			// 상세 페이지에 쓰고 말 거기 때문에 request
			request.setAttribute("map", map);
			/*
			request.getRequestDispatcher("WEB-INF/views/board/board_detail.jsp").forward(request, response);
			*/
			path = "board/board_detail";
		} else {
			request.setAttribute("msg", "게시글이 없습니다.");
			/*
			request.getRequestDispatcher("WEB-INF/views/common/result_page.jsp").forward(request, response);
			 */
			path = "common/result_page";
		}
		
		// 공통삭제
		request.getRequestDispatcher("WEB-INF/views/" + path + ".jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
