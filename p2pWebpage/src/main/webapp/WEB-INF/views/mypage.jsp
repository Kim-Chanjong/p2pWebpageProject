<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%@ include file="../common/menubar.jsp"%>
    
    <div class="outer">
        <br>
        <h2 align="center">마이페이지</h2>
        
        <form id="updateForm" method="post" action="<%=request.getContextPath()%>/update.me">
            <table>
                <tr>
                    <td width="200px">* 아이디</td>
                    <td><input type="text" name="userId" value="<%= id %>" readonly></td>
                    <td width="200px"></td>
                </tr>
                <tr>
                    <td>* 이름</td>
                    <td><input type="text" name="userName" value="<%= userName %>" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td>연락처</td>
                    <td><input type="tel" name="phone" value="<%= phone %>" placeholder="(-없이)01012345678"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" name="email" value="<%= email %>"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address" value="<%= address %>"></td>
                    <td></td>
                </tr>
                <%-- <tr>
                    <td>관심분야</td>
                    <td>
                        <input id="sports" type="checkbox" name="interest" value="운동" <%= checkedInterest[0] %>>
                        <label for="sports">운동</label>
                        
                        <input type="checkbox" id="climbing" name="interest" value="등산" <%= checkedInterest[1] %>>
                        <label for="climbing">등산</label>
                        
                        <input type="checkbox" id="fishing" name="interest" value="낚시" <%= checkedInterest[2] %>>
                        <label for="fishing">낚시</label>
                        
                        <input type="checkbox" id="cooking" name="interest" value="요리" <%= checkedInterest[3] %>>
                        <label for="cooking">요리</label>
                        
                        <input type="checkbox" id="game" name="interest" value="게임" <%= checkedInterest[4] %>>
                        <label for="game">게임</label>
                        
                        <input type="checkbox" id="etc" name="interest" value="기타" <%= checkedInterest[5] %>>
                        <label for="etc">기타</label>
                    </td>
                    <td></td>
                </tr> --%>
            </table>
            <br>
            
            <div class="btns" align="center">
                <button type="submit" id="updateBtn">수정하기</button>
                
                <button type="button" id="pwdUpdateBtn" onclick="">비밀번호 변경</button>
                <button type="button" id="deleteBtn" onclick="">탈퇴하기</button>
            </div>
        </form>
    </div>


</body>
</html>