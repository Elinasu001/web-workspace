package com.kh.java.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;


@WebServlet("/ajax2.do")
public class AjaxController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값뽑기
		String id = request.getParameter("id"); // study의 객체의 key값
		String pwd = request.getParameter("pwd");
		
		Member member = new Member();
		member.setUserId(id);
		member.setUserPwd(pwd);
		
		Member loginMember = new MemberService().login(member);
		//System.out.println(loginMember);
		
		String name = loginMember.getUserName();
		String email = loginMember.getEmail();
		
		response.setContentType("text/html; charset=UTF-8");
		/*
		response.getWriter().print(name); // print는 인자를 하나밖에 못받는다.
		response.getWriter().print(email); //그럼 print 두번 사용 ...? 이럴 경우 아이디와 이메일 붙어서 나옴 여러개 나올 경우 가독성 현저히 떨어짐
		
		그래서 옛날에는 이걸 xml 형식으로보냈었음
		response.getWriter().print("<name>" + name + "</name>"); 
		response.getWriter().print("<email>" + email + "</email>"); 
		
		근데 많을 경우 복잡하니 아래와 같이 사용하게 됨.
		*/
		
		// AJAX 활용하는데 실제 값을 여러 개 응답하고 싶음
		// JSON 형태로 처음부터 이 형태로 보내면 더 수월함
		// 주의 할 점은 진짜 자바스크립트 객체가 아닌 앞단을 위해 문자열로 보냄
		// JSON 형태로 데이터를 가공해서 앞단으로 응답해주기
		// 1. 배열 / 2. 객체
		
		// 1. 배열
		// [name, email]
		// ['홍길동, 'hong@kh.com']
		//String responseData = "[\"" + name + "\",\"" + email + "\"]";
		//System.out.println(responseData); // ['망아지3','hong@kh.ac.kr']
		//response.setContentType("application/json; charset=UTF-8"); // json 으로 '' 보낼 경우 parseerror 남
		//response.getWriter().print(responseData);					// json은 규칙이 엄격하니 양옆을 "" 해줘야된다 근데 우리는 ' 했으니 전부다 "호 해줘야된다.
																	// 그럼 요청 성공
		
		// 만약 위에처럼 하게됐는데 값들이 많다면...? 이걸 위해 더 쉬운 방법이 있음 json-simple.jar 사용하기
		/*
		 * 라이브러리를 사용해서 JSON 형태의 데이터 만들기
		 * 1. JSONArray
		 * 2. JSONObject
		 */
		JSONArray array = new JSONArray();
		// list에 요소 추가
		array.add(name); // ["홍길동"] 알아서 이렇게 적용함
		array.add(email); // ["홍길동", "hong@kh.com"]
		
		response.setContentType("application/json; charset=UTF8");
		//response.getWriter().print(array); 2번 사용하기 위해 주석 처리		
		
		// 근데 index로 관리하는 것보다 key 값이 담겨 있다면 좀 더 명확하니(가독성 좋아짐, 코드분석 빠르고 유지보수에 좋다) JSONObject 사용 
		// 자바에서는 map이 하고 자바스크립트는 객체가 함.
		// 일반적으로 개발자에게는 효율성이 좋은 index 보다 key값이 명확히 보여 코드 분석이 빠른 객체 형식이, key: value 형식이 좋다.
		// 2. 객체
		JSONObject obj = new JSONObject(); // hashMap을 extends 해서 만든 것 
		// put()
		obj.put("name", name);
		obj.put("email", email);
		response.getWriter().print(obj);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
