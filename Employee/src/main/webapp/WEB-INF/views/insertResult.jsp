<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/resources.jsp" %>
<title>직원 추가 확인</title>
</head>
<body>
<div id="wrap">
	<table class="table table-dark table-hover">
	  <thead>
	    <tr>
	      <th scope="col">사원명</th>
	      <th scope="col">주민등록번호</th>
	      <th scope="col">이메일</th>
	      <th scope="col">번호</th>
	      <th scope="col">부서코드</th>
	      <th scope="col">직급코드</th>
	      <th scope="col">급여등급</th>
	      <th scope="col">급여</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <td>${ insert.empName }</td>
	      <td>${ insert.empNo }</td>
	      <td>${ insert.email }</td>
	      <td>${ insert.phone }</td>
	      <td>${ insert.deptCode }</td>
	      <td>${ insert.jobCode }</td>
	      <td>${ insert.salLevel }</td>
	      <td>${ insert.salary }</td>
	    </tr>
	  </tbody>
	</table>
</div>
</body>
</html>