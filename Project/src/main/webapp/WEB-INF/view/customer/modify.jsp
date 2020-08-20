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
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 수정</title>
</head>
<body>
<form method="post">

<label>제목</label>
<input type="text" name="customer_WriteTitle" value="${view.customer_WriteTitle}"/><br />

<label>작성자</label>
<input type="text" name="customer_Name" value="${view.customer_Name}"/><br />

<label>내용</label>
<textarea cols="50" rows="5" name="customer_Content" maxlength="1000">
${view.customer_Content}</textarea><br />

<input type="hidden"
			name="date_Created" value="${today}" id="date_Created" readonly/>

<label>작성자번호</label>			
<input type="text" name="customer_Num" size="2"/><br>

<button type="submit">수정</button>

</form>
</body>
</html>