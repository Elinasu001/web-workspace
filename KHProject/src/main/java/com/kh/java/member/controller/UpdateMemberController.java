package com.kh.java.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;

@WebServlet(asyncSupported = true, urlPatterns = { "/update.me" })
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateMemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1) get? post?
		request.setCharacterEncoding("UTF-8");

		// 2) 요청 시 전달 값 뽑기 (키값)
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");

		// 2_2) session 에서 값을 뽑아서갈 것:: 수정하기위한 식별값 필요, session 으로 가져오는 것이 안전
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("userInfo");
		Long userNo = member.getUserNo();
		// Long l = ((Member)session.getAttribute("userInfo")).getUserNo();

		// 3) 어따 담기?? MEMBER에 담는게 맞지만 MAP 에 담아 보기
		// map 두 가지 방식
		// 1. new HashMap<> 방식 // 가변(Mutable) → put(), remove() 등으로 값 수정 가능. // 아무
		// Key-Value 조합이나 얼마든지 넣을 수 있음.
		/*
		 * Map<String, String> map = new HashMap(); map.put("userName", userName);
		 * map.put("email", email);
		 */

		// 2. Map.of(...) 방식 (Java 9 이상) // 불변(Immutable) Map → 한 번 생성하면 수정 불가. / key,
		// value 쌍을 최대 10개까지 한 번에 넣을 수 있음. // 조회(read-only) 목적 // 응답 DTO 변환 등).
		// 더 편한 방법 // Long 을 문자열로 변환 해줘야됨. => map 은 String String 임
		Map<String, String> map = Map.of("userName", userName, "email", email, "userNo", String.valueOf(userNo)); // key,
																													// value
		// System.out.println(map);

		// 4) 요청처리 => Service
		int result = new MemberService().update(map);

		if (result > 0) {
			// 최종적으로 갱신한 값은 테이블에 있다 즉, 최신 데이터를 조회 하려면 db 테이블까지 가야한다.
			// 출력하려면 어떤걸 가져와야되는가?
			// 우리에게 생긴 문제점
			// 업데이트 성공했는데 Session serInfo 키 값에는
			 // 로그인 당시 / 마이페이지 포퉈딩 당시 존재했던
			// 값드이 필드에 담겨있기 때문에
			// UPDATE 수행 전 값들이 마이페이지에서 출력됨
			
			// 목표 => DB가서 갱신된 회원정보 들고오기
			// 	   => 들고온 회원정보 userInfo로 덮어씌우기
			
			//Member로 반환 받아야되는데 오래 걸리니
			/*
			Member loginInfo = new MemberService().login(member);
			session.setAttribute("userInfo", loginInfo);
			
			request.getRequestDispatcher("/WEB-INF/views/member/my_page.jsp").forward(request, response);
			System.out.println("수정에 성공하였습니다.");
			*/
			// sendRedirect
			// kh/myPage 에 가면 위에 있는게 그대로 있음
			session.setAttribute("alertMsg", "정보변경 성공 ~!!!!");
			response.sendRedirect(request.getContextPath() + "/myPage");
			
			
			
		} else {
			request.setAttribute("msg", "정보 수정에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
			System.out.println("수정에 실패하였습니다.");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
