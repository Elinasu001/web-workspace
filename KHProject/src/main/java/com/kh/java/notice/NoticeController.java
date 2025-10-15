package com.kh.java.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeController {
	// 값뽑기
	// 가공
	// 요청처리
	// 응답화면 지정
	// private NoticeService ns = new NoticeService();
	public String insert(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("abc");
		int result = 0;
		if(result > 0) {
			return "/WEB-INF/views/notice/insert.jsp";
		}
		return "/WEB-INF/views/common/fail.jsp";
	}
	
	public String select(HttpServletRequest request, HttpServletResponse response) {
	    // 요청값 꺼내기 (예: 게시글 번호, 검색어 등)
	    String name = request.getParameter("abc");
	    System.out.println("select 요청 도착 : " + name);

	    // 서비스 호출 (ex. DB 조회)
	    // List<Notice> list = ns.selectNoticeList();

	    // 조회 결과를 request 영역에 담기
	    // request.setAttribute("list", list);

	    // 보여줄 JSP 경로 반환
	    return "/WEB-INF/views/notice/select.jsp";
	}
}
