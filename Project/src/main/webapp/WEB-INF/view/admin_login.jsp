<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 로그인</title>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<c:if test="${member == null}">
		<form method="post" action="admin_login">
			<div class="form-group has-feedback">
				<label class="control-label" for="userId">아이디 : </label>
				<!-- 이메일로 가입함 -->
				<input class="form-control" type="text" id="AadminId" maxlength="40"
					placeholder="이메일을 입력해 주세요" name="admin_Id" />
			</div>
			<br>
			<div class="form-group has-feedback">
				<label class="control-label" for="userPass">패스워드 : </label> <input
					class="form-control" type="password" id="AadminPass" maxlength="40"
					placeholder="비밀번호" name="admin_Password" />
			</div>
			<br>
			<div class="form-group has-feedback">
				<button class="btn btn-success" type="submit" id="login">로그인</button>
				<button class="btn btn-success" type="submit" id="logout">로그아웃</button>
			</div>
			<div class="form-group has-feedback">
				<p>
					<input type="button" value="회원가입"
						onclick="location.href='admin_Join'">
				</p>
			</div>
		</form>
	</c:if>
	<c:if test="${msg == false}">
		<p style="color: #f00;">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력해주십시오.</p>
	</c:if>
	<c:if test="${member != null}">
		<p>${member.admin_Name}님 환영합니다.</p>
		<!-- <p><a href="logout">로그아웃</a> -->
	</c:if>
</body>
</html>