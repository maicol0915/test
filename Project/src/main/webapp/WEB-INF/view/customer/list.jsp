<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 목록</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>고객 고유번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.customer_WriteNo}</td>
					<td>
						<a href="view?customer_WriteNo=${list.customer_WriteNo}">${list.customer_WriteTitle}</a>
					</td>
					<td>${list.customer_Name}</td>
					<td>${list.date_Created}</td>
					<td>${list.customer_Num}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tr>
			<td><a href="write">글쓰기</a></td>
		</tr>
	</table>
</body>
</html>