<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
    <div class="top-bar">
        <div class="inner">
        	
        	<!-- sessionScope에 userInfo가 없을 경우 -->
            <div class="auth-links">
                <a href="/vp/login.fw" class="btn-login line">로그인</a>
                <a href="/vp/join" class="btn-signup">회원가입</a>
            </div>
            
            <!-- sessionScope에 userInfo가 있을 경우 -->
            <div class="auth-links">
                <a href="#login" class="btn-login line">로그아웃</a>
                <a href="#signup" class="btn-signup">내정보</a>
            </div>
            
        </div>
    </div>
    <nav id="gnbFull" aria-label="주요 메뉴">
        
        <div class="inner">
            <a href="/vp" class="logo" aria-label="홈으로">
                <img src="./assets/images/logo.png" alt="">
                <span>valueup</span>
            </a>

            <ul class="menu-list" role="menubar">
                
                <li class="menu-item" role="none">
                    <a href="#secondPage" role="menuitem" aria-haspopup="true" aria-expanded="false">공지사항</a>
                    <div class="menu-sub" role="menu" aria-label="공지사항 하위메뉴">
                        <ul>
                            <li><a href="#">공지사항 등록</a></li>
                            <li><a href="#">공지사항 목록조회</a></li>
                            <li><a href="#">공지사항 수정/삭제</a></li>
                        </ul>
                    </div>
                </li>
                <li class="menu-item" role="none">
                    <a href="#thirdPage" role="menuitem" aria-haspopup="true" aria-expanded="false">일반게시판</a>
                    <div class="menu-sub" role="menu" aria-label="일반게시판 하위메뉴">
                        <ul>
                            <li><a href="#">게시글 작성</a></li>
                            <li><a href="#">게시글 목록조회</a></li>
                            <li><a href="#">게시글 수정/삭제</a></li>
                        </ul>
                    </div>
                </li>
                <li class="menu-item" role="none">
                        <a href="#thirdPage" role="menuitem" aria-haspopup="true" aria-expanded="false">사진게시판</a>
                        <div class="menu-sub" role="menu" aria-label="사진게시글 하위메뉴">
                            <ul>
                                <li><a href="#">사진게시글 작성</a></li>
                                <li><a href="#">사진게시글 목록조회</a></li>
                            </ul>
                        </div>
                    </li>
                <li class="menu-item" role="none">
                    <a href="#firstPage" role="menuitem" aria-haspopup="true" aria-expanded="false">회원서비스</a>
                    <div class="menu-sub" role="menu" aria-label="회원서비스 하위메뉴">
                        <ul>
                            <li><a href="#">내정보변경</a></li>
                            <li><a href="#">회원탈퇴</a></li>
                        </ul>
                    </div>
                </li>
            </ul>

            <div class="hamburger-container">
                <button id="btnMobileMenu" class="hamburger" aria-label="전체 메뉴 열기" aria-controls="mobileMenu" aria-expanded="false">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-menu hamburger-icon"><line x1="4" x2="20" y1="12" y2="12"/><line x1="4" x2="20" y1="6" y2="6"/><line x1="4" x2="20" y1="18" y2="18"/></svg>
                </button>
            </div>
        </div>
    </nav>
</header>

 <aside id="mobileMenu" role="dialog" aria-modal="true" aria-hidden="true" aria-labelledby="mobileMenuTitle">
 <div class="backdrop" data-close="backdrop"></div>
 <div class="sheet">
     <header>
         <h2 id="mobileMenuTitle" style="margin:0;font-size:18px;">전체 메뉴</h2>
         <button type="button" class="close" id="mobileClose">
             <svg xmlns="http://www.w3.org/2000/svg"
                 width="24" height="24"
                 viewBox="0 0 24 24"
                 fill="none"
                 stroke="currentColor"
                 stroke-width="2"
                 stroke-linecap="round"
                 stroke-linejoin="round"
                 class="lucide lucide-x close-icon">
             <line x1="18" y1="6" x2="6" y2="18"/>
             <line x1="6" y1="6" x2="18" y2="18"/>
             </svg>

         </button>
     </header>
     <nav aria-label="전체 메뉴">
         <div class="top-bar">
             <div class="inner">
             
             	 <!-- sessionScope에 userInfo가 없을 경우 -->
                 <div class="auth-links">
	                 <a href="/vp/login.fw" class="btn-login line">로그인</a>
	                 <a href="#signup" class="btn-signup">회원가입</a>
                 </div>
                 
                 <!-- sessionScope에 userInfo가 있을 경우 -->
	             <div class="auth-links">
	                <a href="#login" class="btn-login line">로그아웃</a>
	                <a href="#signup" class="btn-signup">내정보</a>
	             </div>
             </div>
         </div>
         <ul style="list-style:none; margin:0; padding:0">
                <li class="m-acc">
                    <button class="m-acc-btn" aria-expanded="false">공지사항</button>
                    <div class="m-acc-panel m-sub">
                        <a href="#">공지사항 등록</a>
                        <a href="#">공지사항 목록조회</a>
                        <a href="#">공지사항 수정/삭제</a>
                    </div>
                </li>
                <li class="m-acc">
                    <button class="m-acc-btn" aria-expanded="false">일반게시판</button>
                    <div class="m-acc-panel m-sub">
                        <a href="#">게시글 작성</a>
                        <a href="#">게시글 목록조회</a>
                        <a href="#">게시글 수정/삭제</a>
                    </div>
                </li>
                <li class="m-acc">
                    <button class="m-acc-btn" aria-expanded="false">사진게시판</button>
                    <div class="m-acc-panel m-sub">
                        <a href="#">사진게시글 작성</a>
                        <a href="#">사진게시글 목록조회</a>
                    </div>
                </li>
                <li class="m-acc">
                    <button class="m-acc-btn" aria-expanded="false">회원서비스</button>
                    <div class="m-acc-panel m-sub">
                        <a href="#">내정보 변경</a>
                        <a href="#">회원탈퇴</a>
                    </div>
                </li>
            </ul>
        </nav>
    </div>
</aside>
