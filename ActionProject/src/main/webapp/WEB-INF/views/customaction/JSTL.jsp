<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
	URI(Uniform Resource Identifier)
	식별자 - 고유한 이름(PK) -> 실제위치가 아니라 논리적인 식별값
	=> 실제 존재하는 uri이 아니라 라이브러리 안에서 각각 구분하는 식별자이다.
	=> include 안되고 jsp에서 쓰고 싶은 곳마다 써줘야 된다.
	
	URL(Uniform Resource Locator)
	위치정보 -> 실제 파일의 경로나 웹 주소
	
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<h1>JSTL</h1>
	
	<p>
		Jakarta Server Page Standard Tag Library의 약어로<br>
		JSP에서 사용할 수 있는 커스텀 액션 태그 <br>
		
		공통적으로 사용해야하는 코드들의 집합을 보다 쉽게 사용할 수 있도록 태그로 만들어서<br>
		표준으로 제공하는 라이브러리(클래스 모음집)
	</p>
	<hr>
	
	<h3>* 라이브러리 추가</h3>
	1) https://tomcat.apache.org로 접속 <br>
	2) Standard-1.2.5.jar 파일 4개다 다운받기<br>
	3) WEB-INF/lib 폴더에 추가해주기<br>
	
	<h4>* JSTL 선언</h4>
	
	<P>
		JSTL을 사용하고자 하는 해당 JSP파일 상단에 <br>
		(보통 page지시어 바로 밑에)<br>
		taglib지시어를 사용해서 선언함<br><br>
		
		[표현법]<br>
		&lt;%@ taglib prefix="접두어" uri="파일uri"%>
		
	</P>
	
	<hr>
	
	<h4>JSTL Core Library(오늘의 주인공)</h4>
	
	<p>
		변수와 조건문, 반복문 등의 로직과 관련된 태그들을 제공
	</p>
	
	<h5>변수 (사실 변수아님 "속성"선언하기 == Attribute)</h5>		
	
	<pre>
	솔직하게 이야기하겠습니다. 사실 그냥 아까 배운 Scope들에 새로운 속성 추가하는 방법입니다.
	
	[표현법]
	&lt;c:set var="키값" value="리터럴값" scope="스코프영역지정(생략가능)" />
	- Scope에 새로운 Attribute를 추가할 수 있는 태그
	- 더 나아가서 어떤 Scope에 추가할건지도 지정 가능(생략 시 pageScope에 담김)
	
	</pre>
	<c:set var="num1" value="10"/>
	<c:set var="num2" value="20" scope="request" />
	<c:set var="result" value="${ num1 + num2 }" scope="session"/>
	
	num1의 값 : ${ num1 }<br>
	num2의 값 : ${ num2 }<br>
	result의 값 : ${ result }<br>
	
	
</body>
</html>