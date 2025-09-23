<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- response.setContentType("text/html; charset=UTF-8"); -->
<%
	// 이 구문은 스크립틀릿(scriptlet)이라고 함
	// 자바코드를 그냥 쓸 수 있음
	
	// 현재 이 JSP상에서 필요한 데이터들을 => request 의 Attribute에서 뽑아내기
	// request.getAttribute("키값"); : Object
	
	int age = (int)request.getAttribute("age"); // 주소값이 정수값으로 왜 바뀌는가? 
	double height = (double)request.getAttribute("height");
	String name = (String)request.getAttribute("name");
	String gender = (String)request.getAttribute("gender");
	String city = (String)request.getAttribute("city");
	String[] foods = (String[])request.getAttribute("foods");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#name{color:orange;}
	#age{color:orangered;}
</style>
<body>
	<h1>${msg}</h1>
	
	<h3><%= name %>님의 정보~</h3>
	
	나이 : <%= age %><br>
	키 : <%= height %><br>
	지역 : <%= city %><br>
	성별 : 
	
	<!--  성별을 선택하지 않았을 경우 -->
	<% if(gender == null) {%>
		선택안함~~~ <br>
	<%} else if("남".equals(gender)){%>
	<!--  성별을 선택했을 경우 -->
		남자임~~~ <br>	
	<%} else {%>
		여자임~~~ <br>
	<%} %>
	
	음식 : 
	<% if(foods == null){ %>
		안골랐음 ~~ <br>
	<%} else {%>
		<ul>
			<% for(int i =0; i < foods.length; i++) { %>
				<li><%= foods[i] %></li>
			<%} %>
		</ul>
	<%} %>
	입니다.
		
</body>
</html>