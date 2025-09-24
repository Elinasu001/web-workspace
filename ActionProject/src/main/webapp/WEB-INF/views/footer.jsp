<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
</head>
<style>
    * {box-sizing: border-box; padding:0; margin:0;}
    ul>li{ list-style: none;}
    ul>li>a{text-decoration: none;}
    div, footer{ box-sizing: border-box;}
    footer{ width:100%; }
    .footer_1,
    .footer_2{ width:100%;}
    .footer_1{height:20%; background-color: #000000;}
    .footer_2{height:80%; background-color: #f7f7f7;}

    .list-info{display:flex; align-items: center; gap:20px; padding:16px; border-bottom: 1px solid #BBBBBB;}
    .list-info li a{position: relative; color: white;}
    .list-info li a::after {content: ""; position: absolute;  height:16px; width:1px;  background-color: white; top:50%; right:-10px; transform: translate(-50%, -50%); }
    .list-info li:last-child a::after{content: none;}

    .p_2{padding:16px; font-size:12px; border-bottom: 1px solid #BBBBBB;}
</style>
<body>
	<footer>
        <div class="footer_1">
            <ul class="list-info">
                <li><a href="#">이용약관</a></li>
                <li><a href="#">개인정보처리방침</a></li>
                <li><a href="#">인재 채용 문의</a></li>
                <li><a href="#">훈련비 게시</a></li>
                <li><a href="#">강사 구인</a></li>
            </ul>
        </div>
        <div class="footer_2">
         	<% String year = new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()); %>
            <p class="p_2">Copyright © 1998-<%= year %> KH Information Educational Institute All Right Reserved</p>
			
			
			include.jsp로 부터 전달 받은 test라는 키값의 value ==> ${ param.test }<br>        
        
        </div>
    </footer>
</body>
<script>
	//const date = new Date();
	
</script>
</html>