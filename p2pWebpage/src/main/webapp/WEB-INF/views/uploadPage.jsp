<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	th{
		font-size: 25pt;
	}
	

</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<form action="fileUploadResult" method="post" enctype="multipart/form-data">
	<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr><th colspan="5">글쓰기</th></tr>
		<tr>
			<td class="a">
				<select style="width:900px; class= "select" name = "categori" >
					<option selected="selected" style="font-size: 15pt">영화</option>
					<option selected="selected" style="font-size: 15pt">게임</option>
					<option selected="selected" style="font-size: 15pt">방송</option>
					<option selected="selected" style="font-size: 15pt">애니</option>
					<option selected="selected" style="font-size: 15pt">유틸</option>
					<option selected="selected" style="font-size: 15pt">문서</option>
					<option selected="selected" style="font-size: 15pt">만화</option>
					<option selected="selected" style="font-size: 15pt">교육</option>
					<option selected="selected" style="font-size: 15pt">기타</option>
				</select>
		</tr>
		
		<tr>
			<td width="800">제목 <input type="text" class="b" name="subject" size="110"/></td>
		</tr>
		
		<tr>
			<td>
				<input type="file" name="fileupload" value="파일 선택"/><br/>
			</td>
		</tr>
		
		<tr>
			<td>
				<textarea rows="22" cols="130" name="content" style="resize: none;"></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="글올리기"/>
			</td>
		</tr>
		
		
	</table>
</form>

</body>
</html>