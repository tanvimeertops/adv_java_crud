<%@page import="com.dao.StudentDao"%>
<%@page import="com.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellspacing="10 px" cellpadding="10 px" width="100%">

<tr>
<th>ID</th>
<th>FIRST NAME</th>
<th>LAST NAME</th>
<th>EMAIL</th>
<th>MOBILE</th>
<th>ADDRESS</th>
<th>GENDER</th>
<th>EDIT</th>
<th>DELETE</th>
</tr>
<%
List<Student> list=StudentDao.getAllStudents();
for(Student s:list)
{
%>
<tr>
<td><%=s.getId()%></td>
<td><%=s.getFname()%></td>
<td><%=s.getLname()%></td>
<td><%=s.getEmail()%></td>
<td><%=s.getMobile()%></td>
<td><%=s.getAddress()%></td>
<td><%=s.getGender()%></td>
<td align="center"> 
<form action="StudentController" name="edit" method="post">
<input type="hidden" name="id" value="<%=s.getId()%>">
<input type="submit" name="action" value="EDIT"> 
</form>
</td>
<td align="center"> 
<form action="StudentController" name="delete" method="post">
<input type="hidden" name="id" value="<%=s.getId()%>">
<input type="submit" name="action" value="DELETE"> 
</form>
</td>
</tr>
<%
}
%>

</table>
</body>
</html>