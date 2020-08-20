<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 등록</title>
</head>
<body>
<section id="container">
			<form method="post" action="a_register">
				<div class="form-group has-feedback">
					<label class="control-label" for="userId">관리자 아이디 : </label>
					<input class="form-control" type="text" id="AadminId" 
					placeholder="이메일을 입력해 주세요" name="admin_Id" />
					<!-- <button type="button" class="CidChk">아이디확인</button>
					id값에따라 function이벤트 발생 -->
				</div>
				<br>
				<!-- <div class="result">
					<hidden><span class="msg">아이디를 체크해 주세요</span></hidden>
				</div> -->
				<div class="form-group has-feedback">
					<label class="control-label" for="userName">관리자 성명 : </label>
					<input class="form-control" type="text" id="AadminName" name="admin_Name" />
				</div>
				<br>
				<div class="form-group has-feedback">
					<label class="control-label" for="userPass">패스워드 : </label>
					<input class="form-control" type="password" id="AadminPass" 
					placeholder="비밀번호" name="admin_Password" />
				</div>
				<br>
				<div class="form-group has-feedback">
					<label class="control-label" for="userEmail">이메일 : </label>
					<input class="form-control" type="text" id="AadminEmail" 
					placeholder="이메일을 입력해 주세요" name="admin_Email" />
				</div>
				<br>
				<div class="form-group has-feedback">
					<label class="control-label" for="userTel">전화번호(-없이 번호만 입력해주세요)</label><br>
					<input class="form-control" type="tel" id="AadminTel" 
					placeholder="Phone Number" maxlength="11" name="admin_PhoneNumber" />
				</div>
				<br>
				<div class="form-group has-feedback">
					<label class="control-label" for="AadminDept">관리자 직급 : </label>
					<select name="dept" >
						<option value="">선택</option>
						<option value="employee">사원</option>
						<option value="supervisor">슈퍼바이저</option>
					</select>
				</div>
				<br>
				<div class="form-group has-feedback">
				<label class="control-label" for="AadminGroup">사용자 그룹 : </label>
					<select name="admin_Author">
						<option value="">선택</option>
						<option value="RPD">R&D Planning Division</option>
						<option value="SOT">Service Operation Team</option>
						<option value="HRT">HR Team</option>
						<option value="CST">Customer Satisfaction Team</option>
						<option value="URT">UI R&D Team</option>
						<option value="NBRT">New Business R&D Team</option>
						</select>
				</div>
				<br>
				<!-- <div>
				<label for="userName">휴대폰 번호 인증 : </label> <input type="submit"
				name="" />
				</div> -->

				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">관리자 등록</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>
			</form>
		</section>
</body>
</html>