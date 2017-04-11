<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
	<th>Name</th>
	<th>Username</th>
	<th>Password</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Course</th>
	<th>hobbies</th>
</tr>
<c:forEach var="a" items="${data}">

	<tr>
		<td><c:out value="${a.fname}"></c:out></td>
		<td><c:out value="${a.uname}"></c:out></td>
		<td><c:out value="${a.pass}"></c:out></td>
		<td><c:out value="${a.age}"></c:out></td>
		<td><c:out value="${a.gender}"></c:out></td>
		<td><c:out value="${a.course}"></c:out></td>
		<td><c:out value="${a.hob}"></c:out></td>
		<td><a href="edit?id=${a.id}" >Edit</a></td>
		<td><a href="delete?id=${a.id}">delete</a></td>
			
				
</tr>
</c:forEach>
</table>

</body>
</html>