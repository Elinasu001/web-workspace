package com.kh.java.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.vo.PageInfo;

@WebServlet("/search.board")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자가 선택하 옵션과 사용자가 입력한 키워드를 가지고
		// DB상에서 검색해서 나온 조회 결과를
		// 페이징처리까지 끝내서 들고 갈것
		
		String condition = request.getParameter("condition");
		// "writer",  "title",  "content"
		String keyword = request.getParameter("query");
		// 사용자가 입력한 값
		
		Map<String, Object> map = new HashMap();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		
		
		
		// 페이징 처리 로직
		// 1) 조건 검색에 따른 전체 게시글 수 조회
		// (기존 전체 게시글 수와는 달리, keyword 검색이 적용된 상태)
		int listCount = new BoardService().searchedCount(map);
		// 2) 현재 요청한 페이지 번호
		int currentPage = Integer.parseInt(request.getParameter("page"));
		// 3) 페이지 하단에 보여질 페이지 번호 개수 (예: 1~5, 6~10)
		int pageLimit = 5;
		// 4) 한 페이지에 보여줄 게시글 수
		int boardLimit = 5;
		// 5) 전체 페이지 수 (ex. 전체 게시글 22개, boardLimit=5 → maxPage=5)
		int maxPage = (int)(Math.ceil((double)listCount / boardLimit));
		// 6) 현재 페이지 그룹의 시작 페이지 (ex. 6페이지 요청 → startPage=6)
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		// 7) 현재 페이지 그룹의 마지막 페이지 (startPage + pageLimit - 1)
		int endPage = startPage + pageLimit -1;
		// 8) 게시글 목록 조회 시 사용할 OFFSET 값 
		//    (ex. 1페이지 → 0부터, 2페이지 → 5부터 시작)
		int offset = (currentPage - 1) * boardLimit;
		// 9) 마지막 페이지 번호가 실제 최대 페이지를 초과하지 않도록 보정
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 중복코드 .. 책임분리 !
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, startPage, endPage, maxPage, offset);
		
		map.put("offset", offset);
		map.put("limit", boardLimit);
		
		List<Board> boards = new BoardService().selectSearchList(map);
		
		request.setAttribute("boards", boards);
		request.setAttribute("pi", pi);
		request.setAttribute("keyword", keyword);
		request.setAttribute("condition", condition);
		
		request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
