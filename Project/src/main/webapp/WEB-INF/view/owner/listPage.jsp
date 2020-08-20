<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 목록</title>
</head>
<body>
	<table>
			<tr>
				<th width="50">글번호</th>
				<th width="300">글제목</th>
				<th width="100">작성자</th>
				<th width="150">작성일</th>
				<th width="200">고객 고유번호</th>
			</tr>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.owner_WriteNo}</td>
					<td>
						<a href="view?owner_WriteNo=${list.owner_WriteNo}">${list.owner_WriteTitle}</a>
					</td>
					<td>${list.owner_Name}</td>
					<td>${list.date_Created}</td>
					<td>${list.owner_Num}</td>
				</tr>
			</c:forEach>
		<tr>
			<td align="center"><a href="write">글쓰기</a></td>
		</tr>
	</table>
	<div>
		<c:if test="${prev}">
			<span>[<a href="listPage?num=${startPageNum - 1}">이전</a>]
			</span>
		</c:if>
		
		<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
			<span> 
			
				<c:if test="${select != num}">
					<a href="listPage?num=${num}">${num}</a>
				</c:if> 
				
				<c:if test="${select == num}">
					<b>${num}</b>
				</c:if>

			</span>
		</c:forEach>
		
		<c:if test="${next}">
			<span>[<a href="listPage?num=${endPageNum + 1}">다음</a>]
			</span>
		</c:if>
	</div>
	<%-- <div>
	<c:forEach begin="1" end="${pageNum}" var="num">
	<span>
	<a href="list?num=${num }"> ${num}</a>
	</span>
	</c:forEach>
	</div> --%>

</body>
</html>