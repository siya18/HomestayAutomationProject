<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insert">
<table >
<tr><td>Name</td>
<td><input type="text" name="fname" required="required"></td>
</tr>

<tr><td>Username</td>
<td><input type="text" name="uname" required="required"></td>
</tr>
<tr><td>Passowrd</td>
<td><input type="password" name="pass" required="required"></td>
</tr>
<tr><td>Age</td>
<td><input type="text" name="age" required="required"></td>
</tr>

<tr><td>Gender</td>
<td><input type="radio" name="gender"  value="F" required="required">Female
	<input type="radio"  name="gender" value="M" required="required">Male

</td>
</tr>

<tr><td>Course</td>
<td><select name="course" required="required">
<option selected="selected" value="">Select Course</option>
<option value="computer" >Computer Engineering</option>
<option value="IT" >Information and Technology Engineering</option>
<option value="mechanical" >Mechanical Engineering</option>
<option value="electrical" >Electrical Engineering</option>
<option value="EC" >EC Engineering</option>
</select>

</tr>
<tr><td>Hobbies</td>
<td><input type="checkbox" name="hob" value=Painitng >Painting<br>
<input type="checkbox" name="hob" value=reading >Reading<br>
<input type="checkbox" name="hob" value=Surfing  >Surfing<br>
</td>
</tr>
<tr><td><input type="submit" value="Register"> </td></tr>








</table>


</form>
<a href="view">Click to view Records</a>

</body>
</html>