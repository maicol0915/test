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
<meta charset="UTF-8">
<title>게시물 조회</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<form method="post" role="form">
		<label>제목 : </label> ${view.customer_WriteTitle}<br>
		<br>

		<%-- <label>작성자</label>
${view.customer_Name}<br><br> --%>
		<label>작성날짜</label> ${today} <br>
		<br> <label>내용</label><br> ${view.customer_Content}<br>
		<br> 
		
		<input type="hidden" name="customer_WriteNo"
		value="${view.customer_WriteNo}">

	</form>
	<div>
		<button id="modify_btn">게시물 수정</button>
		<button id="delete_btn">게시물 삭제</button><br>
		<script>
			var gle = $("form[role='form']");

			$("#modify_btn").click(function() {
				gle.attr("action", "modify");
				gle.attr("method", "get");
				gle.submit();
			});
			$("#delete_btn").click(function() {
				gle.attr("action", "delete");
				gle.attr("method", "get");
				gle.submit();
			});
		</script>
	</div>
</body>
</html>