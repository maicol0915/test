<%@page import="java.util.Calendar"%>
<%
	Calendar cal = Calendar.getInstance(); // 현재 날짜/시간 등의 각종 정보 얻기
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH) + 1;
int day = cal.get(Calendar.DAY_OF_MONTH);
String monthstr = "";
if (month < 10) {
	monthstr = "0" + month;
} else {
	monthstr = String.valueOf(month);
}
String daystr = "";
if (day < 10) {
	daystr = "0" + day;
} else {
	daystr = String.valueOf(day);
}
String today = year + monthstr + daystr;
request.setAttribute("today", today);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>고객 회원가입</title>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
input[type="number"]::-webkit-outer-spin-button, input[type="number"]::-webkit-inner-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}
</style>
</head>
<body>

	<section id="container">
		<form method="post" action="customer_Join">
			<div class="form-group has-feedback">
				<label class="control-label" for="CuserId">아이디 : </label> <input
					class="form-control" type="text" id="CuserId"
					placeholder="이메일을 입력해 주세요" name="customer_Email" />
				<!-- <button type="button" class="CidChk">아이디확인</button>
					id값에따라 function이벤트 발생 -->
			</div>
			<br>
			<div>
				<label class="control-label" for="CinputCode"></label>


			</div>


			<!-- <div class="result">
					<hidden><span class="msg">아이디를 체크해 주세요</span></hidden>
				</div> -->
			<div class="form-group has-feedback">
				<label class="control-label" for="CuserPass">패스워드 : </label> <input
					class="form-control" type="password" id="CuserPass1"
					placeholder="비밀번호" name="customer_Password" />
			</div>
			<br>
			<div class="form-group has-feedback">
				<label class="control-label" for="CuserPass">패스워드 확인 : </label> <input
					class="form-control" type="password" id="CuserPass2"
					placeholder="비밀번호확인" />
			</div>
			<div class="alert alert-success" id="alert-success">비밀번호가
				일치합니다.</div>
			<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지
				않습니다.</div>
			<br>
			<div class="form-group has-feedback">
				<label class="control-label" for="CuserName">성명 : </label> <input
					class="form-control" type="text" id="CuserName"
					name="customer_Name" />
			</div>
			<br>
			<div class="form-group has-feedback">
				<label class="control-label" for="CuserGender">성별 : </label> <input
					class="form-control" type="radio" id="CgenderM" value="man"
					name="customer_Gender" /> <label for="CgenderM">남자</label> <input
					class="form-control" type="radio" id="CgenderW" value="woman"
					name="customer_Gender" /> <label for="CgenderW">여자</label>
			</div>
			<br>
			<div class="form-group has-feedback">
				<label class="control-label" for="CuserTel">전화번호(-없이 번호만
					입력해주세요)</label><br> <input class="form-control" type="tel"
					id="CuserPhoneNumber" placeholder="전화번호입력" maxlength="11"
					name="customer_PhoneNumber" />
			</div>
			<br>
			<div class="form-group has-feedback">
				<label class="control-label" for="CuserBirth">생년월일 : </label> <input
					class="form-control" type="number" id="CuserBirth"
					placeholder="ex) 20000101" name="customer_Birth" />
			</div>
			<br> <input type="hidden" name="customer_Join_Date"
				value="${today}" id="CuserJoin_Date" readonly />
			<!-- 가입날짜 -->
			<!-- <div>
				<label for="userName">휴대폰 번호 인증 : </label> <input type="submit"
				name="" />
				</div> -->

			<div class="form-group has-feedback">
				<button class="btn btn-success" type="submit" id="submit">회원가입</button>
				<button class="cencle btn btn-danger" type="button">취소</button>
			</div>
		</form>
	</section>

</body>

<script type="text/javascript">
	$(document).ready(function() {
		// 취소
		$(".cencle").on("click", function() {
			location.href = "customer_login";
		})

		$("#submit").on("click", function() {
			if ($("#CuserId").val() == "") {
				alert("아이디를 입력해주세요.");
				$("#CuserId").focus();
				return false;
			}
			if ($("#CuserPass1").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$("#CuserPass1").focus();
				return false;
			}
			if ($("#CuserPass2").val() == "") {
				alert("비밀번호를 확인해주세요.");
				$("#CuserPass2").focus();
				return false;
			}
			if ($("#CuserName").val() == "") {
				alert("성명을 입력해주세요.");
				$("#CuserName").focus();
				return false;
			}
			if ($("#CuserPhoneNumber").val() == "") {
				alert("전화번호를 입력해주세요.");
				$("#CuserPhoneNumber").focus();
				return false;
			}
			if ($("#CuserBirth").val() == "") {
				alert("생년월일 입력해주세요.");
				$("#CuserBirth").focus();
				return false;
			}
		});
	})
	$(function() {
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("input").keyup(function() {
			var CuserPass1 = $("#CuserPass1").val();
			var CuserPass2 = $("#CuserPass2").val();
			if (CuserPass1 != "" || CuserPass2 != "") {
				if (CuserPass1 == CuserPass2) {
					$("#alert-success").show();
					$("#alert-danger").hide();
					$("#submit").removeAttr("disabled");
				} else {
					$("#alert-success").hide();
					$("#alert-danger").show();
					$("#submit").removeAttr("disabled", "disabled");
				}
			}
		});
	});

	function emailSend() {
		var customer_Email = $("#customer_Email").val();
		$.ajax({
			url : "emailSend",
			data : {
				customer_Email : customer_Email
			},
			type : "POST",
			success : function(data) {
				console.log(data);
				alert("이메일로 인증번호가 발송 되었습니다.")
				return false;
			},
			error : function() {

				alert("다시 시도하세요")
				return false;
			}
		});
	}
	function emailCertification() {
		var fal = "false";
		var tr = "true";

		var customer_Email = $("#customer_Email").val();
		var inputCode = $("#inputCode").val();
		$.ajax({
			url : "certification",
			data : {
				customer_Email : customer_Email,
				inputCode : inputCode
			},
			type : "POST",
			success : function(result) {
				console.log(result);
				if (result == true) {
					alert("인증완료되었습니다.");
					$('input[name=certificationYN]').attr('value', tr);
					customer_Email.onchange = function() {
						$('input[name=certificationYN]').attr('value', fal);
					}
					return false;
				}
			},
			error : function() {
				alert("인증번호가 일치하지않습니다, 인증번호를 다시 입력해주세요.");
				return false;
			}
		});
	}
</script>
</html>