<%@page import="com.itp.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student DashBoard</title>
</head>
<body>
	<p>Welcome to Student Dashboard.</p>
	
	<% Student currentUserObj =(Student)session.getAttribute("sessionUsr");%>
	 Welcome <%=currentUserObj.getsId() %>
	 
	 <a href="/schoolmanagement/logOut.jsp">LogOut</a>
	 
	 
</body>
</html>