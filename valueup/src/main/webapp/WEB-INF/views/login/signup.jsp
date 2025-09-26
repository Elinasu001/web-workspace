<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<main div class="boxWrap login">
	<div class="boxArea">
		<form action="login" name="sign-in" method="post" id="signInForm" style="margin-bottom: 0;">
				<table style="width: 100%">
					<tr>
						<td style="text-align: left">
							<p><strong>회원가입</span></p>
						</td> 
					</tr>
					<tr>	
						<td>
							<label for="signUpId" class="form-label">아이디</label>
							<input type="text" id=signUpId name="userId" class="form-control tooltipstered" maxlength="10"  required="required" placeholder="아이디를 입력해주세요." >
							<div id="passwordHelpBlock" class="form-text">
								* 아이디는 영문, 숫자, _, -만 사용할 수 있습니다.
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<label for="signUpPwd" class="form-label">비밀번호</label>
							<input type="password" id=signUpPwd" name="userPwd" class="form-control tooltipstered"  size="17"  maxlength="20"   required="required" placeholder="비밀번호를 입력해주세요." >
							<div id="passwordHelpBlock" class="form-text">
								* 8~16자의 영문 대/소문자, 숫자, 특수문자를 모두 포함하세요.
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<label for="signUpPwd" class="form-label">비밀번호 확인</label>
							<input type="password" id="signUpPw2" name="userPwd" class="form-control tooltipstered"  size="17"  maxlength="20"   required="required" placeholder="비밀번호를 입력해주세요." >
						</td>
					</tr>
					<tr>
						<td>
							<label for="signUpName" class="form-label">이름</label>
							<input type="text" id="signUpName" name="userName" class="form-control tooltipstered"  size="17"  maxlength="20"   required="required" placeholder="비밀번호를 입력해주세요." >
						</td>
					</tr>
					<tr>
						<td>
							<label for="signUpEmail" class="col-sm-2 col-form-label">이메일</label>
							<input type="email" id=signUpEmail name="email" class="form-control tooltipstered" equired="required" placeholder="이메일을 입력해주세요." >
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

<script>
document.addEventListener('DOMContentLoaded', function () {
	const signUpPwd = document.getEl

}
</script>

