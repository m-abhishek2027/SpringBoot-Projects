<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:red; text-align:center;"> <c:out value="${errorMsg}"/> </h3>
	<h3 style="color:green; text-align:center;"> <c:out value="${succMsg}"/></h3>
	<form action="uLogin" method="post">
	<h2>Employee Login Form</h2>
		<p>
			<label>Enter ID:</label>
			<input type="number" name="uid" required="required">
		</p>
		<p>
			<label>Enter Password:</label>
			<input type="text" name="pass" required="required">
		</p>
		<p>
			<input type="submit" value="Login">
			<input type="reset" value="ResetForm">
		</p>
	</form>
</body>
</html>