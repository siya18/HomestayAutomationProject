<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">
<c:forEach var="d" items="${data}">

<input type="hidden" name="id" value="${d.id }">
<table>
<tr>
<td>Name:</td>
<td><input type="text" name="fname" value="${d.fname }"></td>
</tr>
<tr>
<td>username:</td>
<td><input type="text" name="uname" value="${d.uname }"></td>
</tr>
<tr>
<td>password:</td>
<td><input type="password" name="pass" value="${d.pass }"></td>
</tr>
<tr>
<td>Age:</td>
<td><input type="text" name="age" value="${d.age }"></td>
</tr>
<tr>
<td>gender</td>
<td><input type="radio" name="gender"  value="${d.gender}" checked="checked">Female
<input type="radio" name="gender" value="${d.gender}">Male
</td>
</tr>
<tr>
<td>course:</td>
<td><select name="course"  >
<option selected="selected" value="">Select Course</option>
<option value="computer" >Computer Engineering</option>
<option value="IT" >Information and Technology Engineering</option>
<option value="mechanical" >Mechanical Engineering</option>
<option value="electrical" >Electrical Engineering</option>
<option value="EC" >EC Engineering</option>
</select></td>
<tr>
<td>Hobbies:</td>
<td>
<input type="checkbox" name="hob" value="painting" >Painting<br>
<input type="checkbox" name="hob" value="music" >Music<br>
<input type="checkbox" name="hob" value="reading" >REading<br>
<input type="checkbox" name="hob" value="surfing" >Surfing<br>
</tr>
<tr><td><input type="submit" value="update"></td></tr>
</table>
</c:forEach>
</form>

</body>
</html>