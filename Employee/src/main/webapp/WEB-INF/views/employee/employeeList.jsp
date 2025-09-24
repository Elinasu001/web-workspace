<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/resources.jsp" %>
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
         <%@ include file="/WEB-INF/views/include/header.jsp" %>
        <div class="content">
            <div class="tab-wrap">
                <a href="/employee" class="tab">직원 추가</a>
                <a href="#" class="tab on">직원 리스트</a>
            </div>
            <div id="tab1" class="tab-content">
            </div>
            
            <div id="tab2" class="tab-content active">
            	<div class="tab-container">
					<table class="table table-dark table-hover">
					  <thead>
					    <tr>
					      <th scope="col">아이디</th>
					      <th scope="col">이름</th>
					      <th scope="col">주민등록번호</th>
					      <th scope="col">이메일</th>
					      <th scope="col">번호</th>
					      <th scope="col">부서코드</th>
					      <th scope="col">직급코드</th>
					      <th scope="col">급여등급</th>
					      <th scope="col">급여</th>
					      <th scope="col">보너스</th>
					      <th scope="col">사수</th>
					      <th scope="col">고용날짜</th>
					      <th scope="col">퇴직날짜</th>
					      <th scope="col">퇴직여부</th>
					    </tr>
					  </thead>
					  <tbody>
					    <c:forEach var="emp" items="${ empList }">
						    <tr>
						      <td scope="row">${ emp.empId }</td>
						      <td>${ emp.empName }</td>
						      <td>${ emp.empNo }</td>
						      <td>${ emp.email }</td>
						      <td>${ emp.phone }</td>
						      <td>${ emp.deptCode }</td>
						      <td>${ emp.jobCode }</td>
						      <td>${ emp.salLevel }</td>
						      <td>${ emp.salary }</td>
						      <td>${ emp.bonus }</td>
						      <td>${ emp.managerId }</td>
						      <td>${ emp.hireDate }</td>
						      <td>${ emp.entDate }</td>
						      <td>${ emp.entYn }</td>
						    </tr>
					  </c:forEach>
					</table>
				</div>
            </div>
        </div>
    </div>
</body>

</html>