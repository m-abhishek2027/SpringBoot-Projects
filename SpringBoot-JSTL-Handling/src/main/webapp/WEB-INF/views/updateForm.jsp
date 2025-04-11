<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">

		<input type="hidden" name="id" value="${emp.id}">
		
		<p>
		<label>Enter Name:</label>
		<input type="text" name="ename" value="${emp.ename}" required="required">
		</p>
		
		<p>
		<label>Enter Designation:</label>
		<input type="text" name="degn" value="${emp.degn}" required="required">
		</p>
		
		<p>
		<label>Enter Address:</label>
		<input type="text" name="addr" value="${emp.addr}" required="required">
		</p>
		
		<p>
		<label>Enter Mob:</label>
		<input type="number" name="phno" value="${emp.phno}" required="required">
		</p>
		
		<p>
		<label>Enter Salary:</label>
		<input type="number" name="salary" value="${emp.salary}" required="required">
		</p>
		
		<p>
		<label>Enter Salary:</label>
		<input type="password" name="pass" value="${emp.pass}" required="required">
		</p>
		
		
		<p>
			<input type="submit" value="UpdateEmployee">
		</p>
	</form>
</body>
</html>