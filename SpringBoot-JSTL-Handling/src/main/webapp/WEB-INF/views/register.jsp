<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		<p>
		<label>Enter Name:</label>
		<input type="text" name="ename" required="required">
		</p>
		
		<p>
		<label>Enter Designation:</label>
		<input type="text" name="degn" required="required">
		</p>
		
		<p>
		<label>Enter Address:</label>
		<input type="text" name="addr" required="required">
		</p>
		
		<p>
		<label>Enter Mob:</label>
		<input type="number" name="phno" required="required">
		</p>
		
		<p>
		<label>Enter Salary:</label>
		<input type="number" name="salary" required="required">
		</p>
		
			<p>
		<label>Enter Password</label>
		<input type="password" name="pass" required="required">
		</p>
		
		<p>
			<input type="submit" value="AddEmployee">
		</p>
	</form>
</body>
</html>