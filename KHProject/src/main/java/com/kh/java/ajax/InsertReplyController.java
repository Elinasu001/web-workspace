package com.kh.java.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Reply;
import com.kh.java.member.model.vo.Member;

@WebServlet("/insert.reply")
public class InsertReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertReplyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// POST => 인코딩 ______ 더이상 그만 ---- 중복 코드
		// request.setCharacterEncoding("UTF-8");
		
		// request로 부터 뽑기
		Long boardNo  = Long.parseLong(request.getParameter("boardNo")); // 앞단 키값
		String content = request.getParameter("replyContent");	 		 // 앞단 키값
		
		// session에서 뽑기 
		Long userNo = ((Member)request.getSession().getAttribute("userInfo")).getUserNo();
		
		
		// 데이터 가공
		Reply reply = new Reply();
		reply.setRefBno(boardNo);
		reply.setReplyContent(content);
		reply.setReplyWriter(String.valueOf(userNo));
		// 나머지는 시퀀스로 또는 디폴트값 사용 할거임
		
		
		// Service로 요청 
		int result = new BoardService().insertReply(reply);
		
		// 어떤 형태로 보낼건지 ?
		// success / fail
		response.setContentType("text/html; charset=UTF-8");
		// 응답
		response.getWriter().print(result > 0 ? "success" : "fail");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
