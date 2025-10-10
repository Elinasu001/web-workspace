package com.kh.java.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.dto.ImageBoardDto;
import com.kh.java.board.model.service.BoardService;

@WebServlet("/images")
public class ImageListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 제네릭 뭘 담아서 와야되는 지 ? sql문 필요
		// 게시글의 이미지 등록 되어있는 것 까지 데려가료묜?
		
		List<ImageBoardDto> boards = new BoardService().selectImageList();
	
		request.setAttribute("boards", boards);
		
		request.getRequestDispatcher("/WEB-INF/views/image_board/thumbnail_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
