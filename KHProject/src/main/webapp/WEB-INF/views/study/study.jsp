<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
</head>
<body>
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
	
	
	
</body>
</html>