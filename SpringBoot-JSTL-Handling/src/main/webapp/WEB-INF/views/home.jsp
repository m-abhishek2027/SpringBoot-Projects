<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Employee Management</h2>
	
	<h3 style="color:red; text-align:center;"> <c:out value="${errorMsg}"/> </h3>
	<h3 style="color:green; text-align:center;"> <c:out value="${succMsg}"/></h3>
	<a href="add">Add Employee</a>
	<a href="viewAll">ViewAllEmployee</a>
	<a href="logout">logout</a>
	
	
	<c:if test="${not empty list}">
	
		<table>
			<thead>
				<tr>
					<td>EmpId</td>
					<td>Name</td>
					<td>Designation</td>
					<td>Address</td>
					<td>PhoneNo</td>
					<td>Salary</td>
					<td>Password</td>
					<td>Update/Delete</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="emp" items="${list}">
				<tr>
					<td><c:out value="${emp.id}"/></td>
					<td><c:out value="${emp.ename}"/></td>
					<td><c:out value="${emp.degn}"/></td>
					<td><c:out value="${emp.addr}"/></td>
					<td><c:out value="${emp.phno}"/></td>
					<td><c:out value="${emp.salary}"/></td>
					<td><c:out value="${emp.pass}"/></td>
					<td>
						<a href="updateForm?id=${emp.id}">Update</a>/
						<a href="delete?id=${emp.id}">Delete</a>
					</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
	</c:if>
	
	
</body>
</html>