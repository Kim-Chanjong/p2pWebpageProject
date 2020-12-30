<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>home</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<h3>로그인 페이지</h3>
<hr />
		<c:choose>
			<c:when test="${empty sessionScope.id}">
			<!-- 로그인이 안되어 있으면 -->
				<form id="loginForm" name="loginForm" action="loginCheck">
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="id" id="id" placeholder="10글자" maxlength="10"></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="password" name="passwd" id="passwd" maxlength="20"></td>
						</tr>
						<c:if test="${msg == '실패'}">
								<tr>
										<td colspan=2>
									아이디 또는 패스워드가 틀렸습니다.
									</td>
								</tr>
						</c:if>	
						<tr>
								<td colspan=2>
									<input type="button" id="login" value="로그인" />
								</td>
						</tr>
						<tr>
								<td colspan=2>
									<input type="button" id="registerFrm" value="회원가입" onclick="location.href='insert'" />
								</td>
						</tr>
						
				</table>
		</form>
	</c:when>
	<c:otherwise>
				<h3>${sessionScope.id}님 환영합니다.</h3>
				<a href="logout">로그아웃</a>
			</c:otherwise>
	</c:choose>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		$('#login').click(function(){

			// 입력 값 체크
			if($.trim($('#id').val()) == ''){
				alert("아이디를 입력해 주세요.");
				$('#id').focus();
				return;
			}else if($.trim($('#passwd').val()) == ''){
				alert("패스워드를 입력해 주세요.");
				$('#passwd').focus();
				return;
			}
			
			//전송
			$('#loginForm').submit();
		});
		
	});
</script>
</html>
