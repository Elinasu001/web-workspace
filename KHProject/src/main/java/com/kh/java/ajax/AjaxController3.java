package com.kh.java.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.java.board.model.service.BoardService;

@WebServlet("/ajax3.do")
public class AjaxController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("호출 성공 !");
		
		// 게시글 목록 조회 _ pageInfo 만들기 번거로우니 게시글 번호 주고 하나 조회 해보자 ~~
		
		// 조회 3개 했다고 가정
		Map<String, Object> board1 = new BoardService().selectBoard(1);
		Map<String, Object> board2 = new BoardService().selectBoard(2);
		Map<String, Object> board3 = new BoardService().selectBoard(3);
		
		// 돌아오면 이런 모양으로 돌아옴
		List<Map<String, Object>> boards = new ArrayList();
		boards.add(board1);
		boards.add(board2);
		boards.add(board3);
		
		//System.out.println(board1);
		/*
		JSONObject b1 = new JSONObject();
		b1.put("boardNo", ((Board)board1.get("board")).getBoardNo());
		b1.put("boardTitle", ((Board)board1.get("board")).getBoardTitle());
		b1.put("boardWriter", ((Board)board1.get("board")).getBoardWriter());
		
		
		JSONArray arary = new JSONArray();
		arary.add(b1);
		//arary.add(b2)... 위에 생성 여기에어 add까지 추가 하나하나 한다면 비극 ....................
		//그래서 쉽게 하기 위해 구글에서 만든 gson.jar 가 나옴
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(b1);
		*/
		
		// 근데 우리는 하나의 게시글만 보여주는게 아니라 여러개 JSONObject 다룬다면?
		// 배열의 형태를 만들어서 배열에다가 JSONObject 요소를 담아 앞단으로 보내준다.
		
		// 1. Gson : Google이 만든 JSON 라이브러리 사용 : json 형태로 데이터를 만들어서 앞단으로 넘겨줌
		Gson gson = new Gson();
		// 2. Gson객체 생성 후 toJson()를 호출
		response.setContentType("application/json; charset=UTF-8");
		//response.getWriter().print(b1);
		// 3. gson.toJson(응답할 객체, 응답용 스트림);
		//gson.toJson(board1, response.getWriter());
		// 자바스크립트 객체로 넘어가는데  자동으로 키값이 전달하는 객체의 속성명이 됨
		
		// 객체 하나만 넘길 시 JSONObject 형태로 만들어서 응답
		// List 객체는 응답 시 JSONArray 형태 안에 요소로 JSONObject를 만들어서 응답
		// spring 은 gson 사용, spring boot 는 gson 내장이라 쓸 일이 없음
		gson.toJson(boards, response.getWriter()); // 배열 안에 객체로 넘어감
		//0: {boardWriter: 1, board: {…}}
		//1: {boardWriter: 1, board: {…}}
		//2: {boardWriter: 1, board: {…}}length: 3
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
