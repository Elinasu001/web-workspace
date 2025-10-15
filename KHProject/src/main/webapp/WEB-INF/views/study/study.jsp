<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<style>
.contentWrap{padding:20px;}
</style>
<body>
<div class="contentWrap">
	<h1>AJAX</h1>
	<h2>★★★★★ 아주 중요 별이 다섯개!! ★★★★★</h2>
		
	<pre>
	AJAX == Asynchronous JavaScript And XML(옛날에는 XML 주고받음)(SOAP방식))
	
	"페이지를 새로고침 하지 않고 서버와 데이터를 주고받을 수 있는 기술"
	"비동기 통신" => 예) 댓글 (끊기지 않고 부드럽게 이어짐), 에어비앤비 필터링 해서 바로 검색, 인스타 스크롤 ==> 사용자 경험이 좋다 (ux)
	
	우리가 그동안 개발했던 방식은 동기방식
	
	동기방식 :
	1. 사용자가 버튼 클릭
	2. 서버가 요청을 받고 전체 HTML 데이터를 응답
	3. 브라우저가 전체 페이지 다시 로딩-> 깜박임
	
	
	비동기방식 :
	1. 사용자가 버튼 클릭
	2. JavaScript를 이용해서 데이터만 서버로 띡 전송
	3. 서버는 JSON/XML 데이터만 응답
	4. JavaScript를 이용해서 필요한 부분만 갱신 -> 부드럽고, 빠름
	
	---------------- AJAX 장단점 ----------------
	
	장점 : 사용자 경험(UX) 향상
		  서버 부하 감소
		  네트워크 트래픽 절약
	
	
	단점 : SEO 취약
	      브라우저 히스토리 관리 복잡 ( 예외, 에러 났을 때 차지 어려움 )
	      JavaScript 의존성
	      보안 취약점 증가(XSS(Cross-Site Scripting))
	      
	SPA(Single page Application) 전성시대 :: 하나의 HTML 페이지 안에서 모든 화면을 동적으로 교체
	React, Vue, Angular => Ajax기반 라이브러리 및 프레임워크
	</pre>
		
	<h2>JSON</h2>
		
	<pre>
	홍길동(hong)
	아하하 인천의전사독 너무 재밌고
	댓글 0            따봉개수 2 야유 개수1
	
	(구세대 방식)
	<reply>
		<nickName>홍길동</nickName>
		<id>hong</id>
		<content>아하하 인천의전사독 너무 재밌고</content>
		<reply></reply>
		<tabom>2</tabom>
		<uuuu>1</uuuu>
	</reply>
	
	(2005 JSON : xml 불편... JavaScript 객체 모양으로 보내면 편할 것 같다)
	reply : {
		"nickName" : "홍길동",
		"id" : "hong",
		"content" : "아하하 인천의전사독 너무 재밌고",
		reply : [],
		tabom : 2,
		uuuu : 1
	}
	==> google map 나오고 나서 널리 사용됨
	
	(2006 JSON : W3C 국제 표준 승인 )
	- JSON == JavaScript Object Notation
	  "사람이 읽기 쉽고, 기게가 파싱하기 쉬운 데이터 교환 형식, 텍스트 기반이라 아주 가볍다"
	
	  주의 : 진짜로 자바스크립트 객체 xxxxx 자바스크립트 객체 모양으로 "문자열"을 만든 것!
	
	  조심 : 문법이 아주 엄격하늬 자바스크립트 객체라 JSON 객체 사용 형식 잘 알아두기!
	  
	  - 자바스립트 객체
	  {
	  	name : "홍길동",    // 키에 따옴표 없음 가능
	  	address : '서울',  // 작은 따옴표 사용 가능  
	  	age : 15,		  // 마지막 속성값에 컴마 가능
	  }
	  - JSON 형식
	  {
	  	"name" : "홍길동",
	  	"address" : "서울",
	  	"age" : 15
	  }
	  
	 ---------------- JSON 장단점 ----------------
	  
	 장점 :
	 가독성이 뛰어남(XML과 비교해서 훨씬 읽기 쉬움)
	 데이터 자체가 가볍다.(XML 대비해서 30%더 가벼움)
	 파싱 속도 빠름
	 언어 독립적
	 JavaScript 네이티브 지원
	  
	 단점 :
	 주석 불가
	 날짜 타입 없음(문자열로 처리)
	 함수 불가능
	 
	 ** 웹개발의 표준 !! 데이터 형식 **
	 REST API의 기본 포맷!!!
	 설정파일 XML => JSON (설정파일은 YAML이 인기 더 많음)
	</pre>
	
	<pre>
	우리는 AJAX를 이용해서 아이디 중복체크 기능을 구현해볼 예정
	근데 시간이 애매해서 그냥 다음주에 댓글까지 하겠음 아이디 중복체크 + 댓글 기능
	
	AJAX 사용방법
	
	1. XMLHttpRequest객체 사용하기			-- 너무 옛날거라 안함
	2. jQuery 사용해서 ajax메소드 호출하기		-- 학습 예정
	3. fetch API활용해서 fetch 호출하기		-- 학습 예정
	4. Reach 배울 때 Axios 라이브러리 설치해서 사용하기 -- 학습 예정
	</pre>
	
	<pre>
	2. jQuery를 사용한 AJAX 통신 **
	
	[표현법]
	
	$ : $(document).ready(function (){}) =>  $ == jQuery
	
	$.ajax({
		속성명 : 값,
		속성명 : 값,
		속성명 : 값,
		...
	}); ==> 4일 동안 숙제 : WEB으로 CRUD 구현 + 인터페이스/다형성/js 복습
	
	// javascript 값 여러 개 다룰 때 사용하는 것은 ? 
	// 1. 배열(index, 순서 보장 o) | 2. 객체(key:value, 순서 보장 x) [v] 
	
	
	*  주요 속성 
	- url : 요청할 URL(필수로 작성) => form 태그의 action 속성
	- type :요청 전송 방식(GET/POST ... FETCH, PUT, DELETE, OPTION...)
			=> form 태그의 method 속성
	- data : 요청 시 전달값 ({키 : 밸류, 키 : 밸류})
	  		=> form 태그의 input 요소 value 값
	- success : 통신 성공 시 실행할 콜백함수를 정의
	------------------------------------------------------------------------------------------
	- error : 통신 실패 시 실행할 콜백함수를 정의
	- complete : 성공하든 실패하든 무조건 끝나면 실행할 콜백함수를 정의
	</pre>
		
	<hr>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		
	<h2>jQuery를 사용한 AJAX요청 및 응답</h2>
	
	<h3>1. 버튼을 클릭하여 서버에 데이터를 전속하고 단순 문자열데이터 응답받기</h3>
	
	<div class="form-group">
		<div class="form-control">
			입력 : <input type="text" id="input1"/>
		</div>
		
		<div class="form-control">
			<button id="btn1" class="btn btn-sm btn-primary">요청보내기!</button>
		</div>
	</div>
	
	응답 : <label id="outpu1">현재 응답 없음</label>
	
	<script>
		// 요청 보내기 버튼을 클릭하면!
		$("#btn1").click(function(){
			
			// 동기식 요청
			// locaction.href = "ajax1.do?input1=머시기";
			
			// 비동기식 요청(jQuery버전) : 동기식 요청과 다르게 빠름!
			// 필기한 주요 속성 하나하나 사용
			// url 
			$.ajax({
				url : "ajax1.do", 
				type : "get",
				data : {
					value: $("#input1").val()
				},
				success : function(result){
					console.log("ajax요청 성공!");
					console.log(result); // server에서 print해서 보낸 responseData 출력
					$("#outpu1").text(result); // 요청처리 성공이 들어감
				},
				error : function(){
					console.log("ajax요청 실패!");
				},
				complete : function(){
					console.log("나는 무조건 함!");
				}
			});
		});
	</script>
	
	<hr>
	
	<h3>2. 버튼 클릭 시 DB조회 결과 응답</h3>
	
	아이디 : <input type="text" id="userId"/><br>
	비밀번호 : <input type="password" id="userPwd"/> <br>
	<button onclick="memberInfo();">정보조회</button>
	
	<br><br>
	
	<div>사용자 이름 : <label id="name">현재 응답 없음</label></div>
	<div>사용자 이메일 : <label id="email">현재 응답 없음</label></div>
	
	<script>
		function memberInfo(){
			$.ajax({
				url: "ajax2.do",
				type: "post",
				data: {
					id: $("#userId").val(),
					pwd: $("#userPwd").val()
				},
				success: function(response){
					console.log("ajax 요청 성공!");
					
					// JSONArray
					//$("#name").text(response[0]);
					//$("#email").text(response[1]);
					
					// JSONObject
					console.log(response);
					$("#name").text(response.name);
					$("#email").text(response.email);
					
					
				},
				error: function(e){
					console.log(e);
				}
			});
		}
	</script>
	
	<hr>
	
	<h3>3. 서버로 요청 후, 여러 개의 객체 응답받아 출력해보기</h3>
	
	<!-- 게시글 : 아이디를 입력받아 해당 아이디가 작성한 게시글 불러오기 -->
	<!-- 쿼리까지 작업하면 시간 많이 걸리니 일단 여기서 더미데이터 형식으로 처리하기 -->
	<br>
	<div>아이디 입력 : <input type="text" id="search-id"/></div><br>
	<table id="table-result" class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		
		<tbody>
			
		</tbody>
	</table>
	<button class="btn btn-sm btn-danger" onclick="find();">게시글 조회</button>
	<!--  요청 시 전달값 없이 해보자!! -->
	<script>
		function find(){
	
			// 비동기식 요청
			$.ajax({
				url: "ajax3.do",
				type: "get",
				success: function(result){
					
					console.log(result);
					
					// 얼마나 들어올지 모르니 반복문으로 !
					let str = '';
					for(e of result){
						//console.log(e.board);
						const board = e.board;
						str += `
								<tr>
									<td>\${board.boardNo}</td>
									<td>\${board.boardTitle}</td>
									<td>\${board.boardWriter}</td>
								</tr>
								`;
					}
					$('tbody').html(str);
					
				}
			});
			
			
		}
	</script>
	
	
	
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	
</div>
</body>
</html>