<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
 <head>
	<title>ValueUp</title>
	<jsp:include page="WEB-INF\views\include\head.jsp"/>
 </head>
<body id="page-top headerWhite">
	<jsp:include page="WEB-INF/views/include/header.jsp"/>

	<!-- content: 네비게이션 클릭에 따라 바뀌는 부분 -->
     <c:choose>
          <c:when test="${param.view eq 'login'}">
              <jsp:include page="WEB-INF/views/login/login.jsp"/>
          </c:when>
          <c:when test="${param.view eq 'signup'}">
               <jsp:include page="WEB-INF/views/login/signup.jsp"/>
          </c:when>
          <c:when test="${param.view eq 'notice'}">
              없음
          </c:when>
          <c:otherwise>
              <jsp:include page="WEB-INF/views/include/main.jsp"/>
          </c:otherwise>
      </c:choose>
   
	<jsp:include page="WEB-INF/views/include/footer.jsp"/>
	
</body>
</html>
