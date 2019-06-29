<%@page import="com.itp.model.Parent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parent Dashboard</title>
</head>
<body>

	<p>Welcome to Parent Dashboard.</p>
	
	<% Parent currentUserObj =(Parent)session.getAttribute("sessionUsr");%>
	 Welcome <%=currentUserObj.getPid() %>
	 
	 <a href="/SchoolManagementSystem/logOut.jsp">LogOut</a>
	 

</body>
</html>