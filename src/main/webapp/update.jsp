<%@page import="com.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Student s=(Student)request.getAttribute("s");
%>
<form name="update" method="post" action="StudentController">
<table cellpadding="10 px" cellspacing="20 px">
<tr>
<td>
ID
</td>
<td>
<input type="text" name="id" value="<%=s.getId()%>">
</td>
</tr>
<tr>
<td>
First Name
</td>
<td>
<input type="text" name="fname" value="<%=s.getFname()%>" >
</td>
</tr>
<tr>
<td>
Last Name
</td>
<td>
<input type="text" name="lname" value="<%=s.getLname()%>">
</td>
</tr>
<tr>
<td>
Email
</td>
<td>
<input type="text" name="email" value="<%=s.getEmail()%>">
</td>
</tr>
<tr>
<td>
Mobile
</td>
<td>
<input type="text" name="mobile" value="<%=s.getMobile()%>">
</td>
</tr>

<tr>
<td>
Address
</td>
<td>
<textarea rows="5" cols="20" name="address"><%=s.getAddress()%></textarea>
</td>
</tr>

<tr>
<td>
Gender
</td>
<%
if(s.getGender().equalsIgnoreCase("male")){
%>
<td>
<input type="radio" name="gender" value="male" checked="checked">Male
<input type="radio" name="gender" value="female">Female
</td>
<%
}
else if(s.getGender().equalsIgnoreCase("female")){
%>
<td>
<input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female" checked="checked">Female
</td>
<%
}
else{
%>
<td>
<input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female">Female
</td>
<%
}
%>
</tr>

</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" name="action" value="Update">
</td>
</tr>
</table>

</form>
</body>
</html>