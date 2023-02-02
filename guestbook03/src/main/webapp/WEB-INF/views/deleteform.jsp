<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>방명록</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath }/deleteform">
	<input type='hidden' name="no" value="${no }">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="삭제"></td>
		</tr>
	</table>
	</form>
	<br>
	<a href="${pageContext.request.contextPath }">메인으로 돌아가기</a>
</body>
</html>