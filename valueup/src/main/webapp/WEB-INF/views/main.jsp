<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- main css -->
<link rel="stylesheet" href="assets/css/ui/com/main.css"/>
<!-- main script -->
<script type="text/javascript"  src="../valueup/assets/js/ui/com/fullpage.js"></script>

<div id="full-container">
   <div class="section" id="firstPage">
       <div class="content">
           <h1>오늘의 챌린지</h1>
           <p>작은 습관이 모여 큰 변화를 만듭니다.</p>
           <button class="app-link">
               <img src="data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='24' height='25' fill='none' viewBox='0 0 24 25'%3e %3cpath fill='currentColor' d='M19.98 3.058a1 1 0 0 0-.11.01H15a1 1 0 1 0 0 2h2.586L8.293 14.36a1 1 0 1 0 1.414 1.414L19 6.482v2.586a1 1 0 1 0 2 0V4.195a1 1 0 0 0-1.02-1.137ZM5 3.068c-1.093 0-2 .907-2 2v14c0 1.093.907 2 2 2h14c1.093 0 2-.907 2-2v-6a1 1 0 1 0-2 0v6H5v-14h6a1 1 0 1 0 0-2H5Z'/%3e%3c/svg%3e" width="16" height="16" style="filter: invert(100%) sepia(0%) saturate(7500%) hue-rotate(110deg) brightness(98%) contrast(108%); opacity: 1;">
                앱으로 이동
            </button>
        </div>
    </div>
    
    <div class="section" id="secondPage">
        <div class="content">
            <h1>기록과 성장</h1>
            <p>함께 도전하고, 인증하며 보상을 받아보세요.</p>
        </div>
    </div>
    
    <div class="section" id="thirdPage">
        <div class="content">
            <h1>참여형 이벤트</h1>
            <div class="gallery">
                <div class="gallery-item">
                    <a  href="#" class="event-card">
                        <div class="event-banner">
                            <img src="./assets/images/event/e001.png" alt="썸머 세일 페스타 배너">
                        </div>
                        <div class="event-info">
                            <div class="event-title">
                            <span class="badge">N</span>
                            <div class="txt">
                                <span>썸머 세일 페스타 이벤트</span>
                                <span class="d-day">D-294</span>
                            </div>
                            </div>
                            <div class="event-date">2026.03.12 ~ 06.24</div>
                        </div>
                    </a>
                </div>
                <div class="gallery-item">
                    <a  href="#" class="event-card">
                        <div class="event-banner">
                            <img src="./assets/images/event/e002.png" alt="썸머 세일 페스타 배너">
                        </div>
                        <div class="event-info">
                            <div class="event-title">
                                <span class="badge">N</span>
                                <div class="txt">
                                    <span>썸머 세일 페스타 이벤트</span>
                                    <span class="d-day">D-294</span>
                                </div>
                            </div>
                            <div class="event-date">2026.03.12 ~ 06.24</div>
                        </div>
                    </a>
                </div>
                <div class="gallery-item">
                    <a  href="#" class="event-card">
                        <div class="event-banner">
                            <img src="./assets/images/event/e003.png" alt="썸머 세일 페스타 배너">
                        </div>
                        <div class="event-info">
                            <div class="event-title">
                            <span class="badge">N</span>
                            <div class="txt">
                                    <span>썸머 세일 페스타 이벤트</span>
                                    <span class="d-day">D-294</span>
                                </div>
                            </div>
                            <div class="event-date">2026.03.12 ~ 06.24</div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
    
    <div class="section" id="fourthPage">
        <div class="content">
            <h1>포인트 리워드</h1>
            <p>성공적인 도전을 마치면 포인트와 성취감을 동시에!</p>
        </div>
        <footer class="site-footer">
            <p>&copy; 2025 ValueUp Challenge. All rights reserved.</p>
        </footer>
    </div>
</div>

 <ul id="pagination"></ul>