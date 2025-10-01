<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<main class="login masthead boxWrap boxCenter">
	<div class="loginArea boxArea">
		<div class="inner">
			<form action="login" name="sign-in" method="post" id="signInForm" style="margin-bottom: 0;">
				<table style="width: 100%">
					<tr>
						<td style="text-align: left">
							<p><strong>로그인</span></p>
						</td> 
					</tr>
					<tr>	
						<td>
							<input type="text" name="userId" id="signInId" class="form-control tooltipstered" maxlength="10" required="required" aria-required="true" placeholder="아이디를 입력해주세요">
						</td>
					</tr>
					<tr>
						<td class="pt-3">
							<input type="password" size="17" maxlength="20" id="signInPw" name="userPwd" class="form-control tooltipstered" maxlength="20" required="required" placeholder="비밀번호를 입력해주세요">
						</td>
					</tr>
					<tr>
						<td class="d-grid pt-3">
							<button type="submit" id="signIn-btn" class="btn btn-primary btnPrimary">로그인</button>
						</td>
					</tr>
				</table>
			</form>
	</div>
	
</main>

