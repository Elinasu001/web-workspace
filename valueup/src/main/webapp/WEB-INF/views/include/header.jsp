<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container-fluid px-4 px-lg-5">
        <a class="navbar-brand" href="index.jsp">ValueUp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#navbarOffcanvasLg" aria-controls="navbarOffcanvasLg" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="navbarOffcanvasLg" aria-labelledby="navbarOffcanvasLgLabel">
            <div class="offcanvas-header">
                <h4 class="offcanvas-title" id="offcanvasDarkNavbarLabel">ValueUp</h4>
                <button type="button" class="btn-close btn-close-black" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
            	
            	
                <div class="d-flex flex-row-reverse line-wrap">
                <c:choose>
                	<c:when test="${ empty sessionScope.userInfo }">
                    	<span class="line"><a href="index.jsp?view=login">로그인</a><a href="index.jsp?view=signup">회원가입</a></span>
                	</c:when>
                	<c:otherwise>
                    	<span class="line"><a href="index.jsp?view=myinfo">내정보</a><a href="index.jsp?view=logout" onclick="return confirm('진짜로 로그아웃 하려고?')">로그아웃</a></span>
                    </c:otherwise>
                 </c:choose>
                </div>
               
                
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3 pt-4">
                    <li class="nav-item"><a class="nav-link" href="index.jsp?view=notice">공지사항</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="index.jsp?view=board" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            게시판
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">일반게시판</a></li>
                            <li><a class="dropdown-item" href="#">사진게시판</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="#portfolio">내정보</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>


<script>
    document.getElementById("offcanvasDarkNavbarLabel").addEventListener("click", function(){
        location.href = "index.jsp";
    });
</script>