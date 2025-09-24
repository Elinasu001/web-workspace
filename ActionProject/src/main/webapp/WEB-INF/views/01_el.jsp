<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.el.model.vo.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<style>
ul {padding:0; margin:0; }
ul li{list-style:none; padding:0; margin:0; line-height:0; }
</style>
<body>
	<h1>EL구문 배우자! 진짜 조아웅</h1>
	<h3>기존방식 사용</h3>
	<%
		// requestScope => classRoom, student
		String classRoom = (String)request.getAttribute("classRoom");
		Person student = (Person)request.getAttribute("student");
		
		// sessionScope => academy, lecture
		String academy = (String)session.getAttribute("academy");
		Person lecture = (Person)session.getAttribute("lecture");
	%>
	
	<%-- 
	<pre>
	학원명 : <%= academy %>
	강의장 : <%= classRoom %>
	강사정보 : <%= lecture.getName() %>, <%= lecture.getAge() %>, <%= lecture.getAddress() %>
	
	수강생의 정보
		<ul>
			<li>이름 : <%= student.getName() %></li>
			<li>나이 : <%= student.getAge() %></li>
			<li>주소 : <%= student.getAddress() %> </li>
		</ul>
	</pre>
	--%>
</body>
</html>