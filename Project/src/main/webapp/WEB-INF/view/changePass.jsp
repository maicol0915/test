<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>내정보 보기</title>

<script language="JavaScript">
	function changePw() {
		if (document.newPw.customer_password.value != document.newPw.customer_password2.value) {
			alert("비밀번호가 다릅니다.");
			document.newPw.customer_password2.focus();
			return false;
		}else if(document.newPw.customer_password.value == '' &&document.newPw.customer_password2.value == ''){
			alert("비밀번호를 입력하세요.")
			return false;}
		else{
			alert("비밀번호 변경이 완료되었습니다.")
			}
	}
</script>
</head>
<body>
<b>내정보 수정</b>
	<form method="post" name="newPw" action="newPw" onsubmit="return changePw()" >
	<input type="hidden" id="customer_Email" name="customer_Email" value="${customer_Email}">
		
		<label>변경할 비밀번호</label>
		<input type="password" name="customer_password" /><br /> 
		
		<label>변경비밀번호	확인</label> 
		<input type="password" name="customer_password2" /><br /> 
		

		<button type="submit">수정</button>
	</form>
     
</body>
</body>
</html>