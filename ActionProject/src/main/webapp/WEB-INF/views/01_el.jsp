<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.el.model.vo.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<style>
ul {padding:0; margin:0; }
ul li{list-style:none; padding:0; margin:0; line-height:0; }
</style>
<body>
	<h1>EL구문 배우자! 진짜 조아웅</h1>
	<h3>기존방식 사용</h3>
	<%
		// requestScope => classRoom, student
		String classRoom = (String)request.getAttribute("classRoom");
		Person student = (Person)request.getAttribute("student");
		
		// sessionScope => academy, lecture
		String academy = (String)session.getAttribute("academy");
		Person lecture = (Person)session.getAttribute("lecture");
	%>
	
	<%-- 
	<pre>
	학원명 : <%= academy %>
	강의장 : <%= classRoom %>
	강사정보 : <%= lecture.getName() %>, <%= lecture.getAge() %>, <%= lecture.getAddress() %>
	
	수강생의 정보
		<ul>
			<li>이름 : <%= student.getName() %></li>
			<li>나이 : <%= student.getAge() %></li>
			<li>주소 : <%= student.getAddress() %> </li>
		</ul>
	</pre>
	--%>
	
	<hr>
	
	<h3>
		EL 구문을 이용해서 request / session 에 담긴 값들을 출력
	</h3>
	
	
	<p>
		학원명 : ${academy} <br>
		강의장 : ${classRoom} <br>
		강사 정보 : ${lecture.name}, ${lecture.age}, ${lecture.address} <br>
		<!-- 
			private임...
			실제로 필드에 직접 접근한게 아님
			private 필드에 직접 접근하는 것이 아니라, 공개(public)된 Getter 메서드를 통해 안전하게 데이터를 가져오는 방식
			${lecture.name}은 실제로 lecture.getName() 메서드를 호출
			, EL은 이 규칙에 따라 자동으로 메서드를 찾아 값을 가져오는 것
			name -> getName() 
			내부적으로 getter메소드를 찾아서 호출해서 값을 출력해주는 구조
			
			lecture에 저근했을 때 value는 Person타입 객체
			해당 Person객체의 각 필드값을 출력하려고 한다면 키값.필드명을 작성하면
			해당 필드에 네이밍컨벤션에 부합하는 getter를 찾아서 호출해줌
		 -->
	</p>
	
	
	
	<%--
		int num = (int)request.getAttribute("num");
	--%>
	
	<p>없는 키값을 출력하는 경우</p>
	<p>출력식을 사용함 : &lt;%= num %></p>
	<p>EL구문을 사용함 : \${gr}</p>
	
	<hr>
	
	<h3>3. EL 사용 시 키값이 동일한 경우</h3>
	key 라는 키값에 담긴 밸류 : ${key} <br>
	
	<%
		// pageScope에 속성추가
		pageContext.setAttribute("key", "pagekey");
	%>
	
	다시 출력해보기 : ${key}<br> <!-- 밑에 있는 key가 우선순위가 높다 -->
	<!-- 
		EL 구문은 가장 작은 범위의 scope부터 키값을 검색함
		
		page => request => session => application 순으로 키값을 찾음
		
		모든영역에 키가 존재하지 않았다?
		아무일도 일어나지 않음 오류안남	
		
	 -->
	 
	 pageScope에 값이 담겨있는데, 다른 Scope의 값을 사용하고 싶다면?? <br>
	 
	 ==> Scope에 직접 접근하기 <br><br>
	 
	 requestScpe: ${ requestScope.key }<br>
	 sessionScope: ${ sessionScope.key }<br>
	 applicationScope: ${ applicationScope.key } <br>
	 
	<hr>
	
	
	<h2>EL구문을 이용해서 연산해보기</h2> 
	
	<p>
		산술연산<br>
		big + small = ${ big + small }<br>
		big - small = ${ big - small }<br>
		big x small = ${ big * small }<br>
		big / small = ${ big / small } 또는 ${ big div small }<br>
		big % small = ${ big % small } 또는 ${ big mod small }<br>  <!-- 기본적으로 키워드 사용할 수 있으면, 키워드 사용! -->
	</p>
	
	<hr>
	
	<h3>숫자간의 대소비교 연산</h3>
	<p>
		big이 small보다 크니? : ${ big > small } 또는 ${ big gt small }<br>
		big이 small보다 작니? : ${ big < small } 또는 ${ big lt small }<br>
		big이 small보다 크거나 같니? :  ${ big >= small } 또는 ${ big ge small }<br>
		big이 small보다 작거나 같니? :  ${ big <= small } 또는 ${ big le small }<br>
	</p>
	
	
	<hr>
	
	<h3>동등비교 연산</h3>
	
	
	<p>
		big과 small이 같습니까? : ${ big == small } 또는 ${ big eq small }<br>
		big과 10이 같습니까? : ${ big == 10 } 또는 ${ big eq 10 }<br>
		
		strOne 과 strTwo 가 같습니까? : ${ strOne == strTwo } 또는 ${ strOne eq strTwo }<br> <!-- 자바에서는 == 주소와 주소 비교라서 false지만 여기서는 eq 메서드라 리터럴 비교라서 true 이다. -->
		<!-- EL구문에서의 문자열 == 비교는 자바에서는 equals()와 같은 동작을 함 -->
		strOne에 담긴값과 "안녕"이 일치하나요? : ${ strOne == "안녕" } 또는 ${ strOne == '안녕' }<br>  <!-- ""쓰든 ''쓰든 일치 -->
		strOne과 strTwo가 같지 않습니까? : ${ strOne != strTwo } 또는 ${ strOne ne strTwo }<br>
	</p>
	
	
	
	<hr>
	
	<h3>4. 객체가 null인지 또는 리스트가 비어있는 체크</h3>
	
	<p>
		* 기존방식 <br>
		스크립틀릿으로 if()
		객체 == null
		리스트.isEmpty()
	</p>
	
	<p>
		* EL구문 <br>
		
		 obj가 null 과 일치합니까? <br>
		 ${ obj == null	} 또는 ${ obj eq null } 또는 ${ empty obj }<br><br>
		 
		 
		 list가 비어있습니까? ; ${ empty list }<br>
		 lsit가 비어있지 않습니까? : ${ !empty list }<br>
	</p>
	
	<hr>
	
	<h3>5. 논리연산자</h3>
	<p>
	
		AND 연산 :  ${ true && false } 또는 ${ true and false }<br>
		OR  연산 :  ${ true || true } 또는 ${ true or false }<br>
	
	</p>
	
	<br><br>
	
	${ classRoom }, ${academy }
	
	<!-- 
		JSP를 이루는 구성 요소
		
		1. Scripting Element : JSP상에서 자바코드를 직접 기술할 수 있게 해주는 요소
		2. 문자열 : HTML, CSS , JS
		3. 지시어	 : JSP페이지 정보를 기술한다거나 (page) 포함시킬 땓 사용 (include)
		4. JSP Action Tag : XML 기술을 사용해서 기존의 JSP문법을 확장하는 용도로 사용하는 태그
	
	 -->
	 
	 
	 <h2>* JSP Action Tag</h2>
	 
	 <h3>1. 표준 액션 태그</h3>
	 <a href="/action/include.do">02_include</a>
	 <a href="/action/forward.do">03_forward</a>
	 
	 <h3>★★★★ 2. 커스텀 액션 태그 ★★★★</h3>
	 <a href="/action/jstl.do">04_JSTL</a>
	 
	 
</body>
</html>