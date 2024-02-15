<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="insert" method="post" action="StudentController">
<table cellpadding="10 px" cellspacing="20 px">
<tr>
<td>
First Name
</td>
<td>
<input type="text" name="fname">
</td>
</tr>
<tr>
<td>
Last Name
</td>
<td>
<input type="text" name="lname">
</td>
</tr>
<tr>
<td>
Email
</td>
<td>
<input type="text" name="email">
</td>
</tr>
<tr>
<td>
Mobile
</td>
<td>
<input type="text" name="mobile">
</td>
</tr>

<tr>
<td>
Address
</td>
<td>
<textarea rows="5" cols="20" name="address"></textarea>
</td>
</tr>

<tr>
<td>
Gender
</td>
<td>
<input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female">Female
</td>
</tr>

</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" name="action" value="Insert">
</td>
</tr>
</table>

</form>
</body>
</html>