<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>board</title>

</head>
<body>

<article>
	<div class="container">
		<div class="table-responsive">
			<table class="table table-striped table-sm"></table>
			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm" onclick="location.href='uploadPage'">글쓰기</button>
			</div>
		</div>
	</div>
</article>
<article>
	<div class="container">
		<div class="table-responsive">
			<table class="table table-striped table-sm"></table>
			<div>
				<button type="button" class="btn btn-sm btn-primary" id="home" onclick="location.href='index'">홈으로</button>
			</div>
		</div>
	</div>
</article>

<h2>board list</h2>
	<table>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:auto;" />
			<col style="width:15%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
		</colgroup>

		<thead>
			<tr>
				<th>No.</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty boardList }" >
					<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
				</c:when> 
				<c:when test="${!empty boardList}">
					<c:forEach var="list" items="${boardList}">
						<tr>
							<td><c:out value="${list.bid}"/></td>
							<td><c:out value="${list.title}"/></td>
							<td><c:out value="${list.reg_id}"/></td>
							<td><c:out value="${list.view_cnt}"/></td>
							<td><c:out value="${list.reg_dt}"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
	</table>
</body>
</html>