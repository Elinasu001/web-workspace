<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF\views\include\head.jsp"/>
<!-- main css -->
<!-- main script -->
<title>valueup</title>
</head>

<body>
<div id="wrap">
	<jsp:include page="/WEB-INF/views/include/inc_header.jsp"/>
 	<div class="contentWrap">
           <div class="contArea login">
               <div class="loginArea">
                   <form action="signIn">
                       <div class="form-wrap">
                           <h3><img src="${pageContext.request.contextPath}/assets/images/Icon.png" class="upicon">로그인<span class="flag">Admin</span></h3>
                           <div class="form-group mt30 "><!-- user-invalid -->
                               <input id="userId" type="text" name="userId" maxlength="14" required class="form-control" placeholder="아이디">
                               <p class="feedback">아이디를 입력해주세요</p>
                           </div>
                           <div class="form-group mt20"><!-- user-invalid -->
                               <input id="userPwd" type="password" name="userPwd" size="17" maxlength="30" required class="form-control" placeholder="비밀번호">
                               <p class="feedback">비밀번호를 입력해주세요</p>
                           </div>
                       </div>
                       <div class="btn-area mt30">
                           <button type="button" class="btn btn-primary">로그인</button>
                       </div>
                       <div class="util-wrap">
                           <ul class="util-list">
                               <li><a href="#none" class="se-btn">아이디 찾기</a></li>
                               <li><a href="#none" class="se-btn">비밀번호 찾기</a></li>
                           </ul>
                       </div>
                   </form>
               </div>
           </div>
       </div>
	<jsp:include page="/WEB-INF/views/include/inc_footer.jsp"/>
</div>
</body>
</html>

