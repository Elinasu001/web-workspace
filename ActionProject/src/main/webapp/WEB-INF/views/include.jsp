<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인쿠루드</title>
</head>
<body>
	<h1>include</h1>
	
	<p>
		다른 페이지를 포함할 때 사용
	</p>
	
	<%--
	<%@ include file="footer.jsp" %>
	<%@ include file="footer.jsp" %>
	 --%>
	<!-- 이럴 경우 정적으로 불러오는 형식이라 한 번 더 동일한 include를 사용 할 수없다.-->

	<h4>JSP표준 액션 태그를 이용한 방시(동적 include)</h4>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="footer.jsp"/>
	<!-- 
		xml 기반 기술이기 때문에 반드시 시작태그와 종료태그가 쌍으로 존재해야함.
		닫는 태그를 작성하지 않으면 500에러가 발생한다.
	 -->
	 
	 <hr>
	 
	 <!-- 하 ㅜㅜ 하면 500에러 -->
	 <!-- Content영역에 주석넣지 않기! -->
	<jsp:include page="footer.jsp">
		<jsp:param name="test" value="Hi"/>
	</jsp:include>
	
	<jsp:include page="footer.jsp">
		<jsp:param name="test" value="Bye"/>
	</jsp:include> 
	 
</body>
</html>