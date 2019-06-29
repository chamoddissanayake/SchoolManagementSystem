<%@page import="com.itp.model.AdministrativeStaff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrative Staff Dashboard</title>
</head>
<body>
	<p>Welcome to Administrative Staff Dashboard.</p>
	
	<% AdministrativeStaff currentUserObj =(AdministrativeStaff)session.getAttribute("sessionUsr");%>
	 Welcome <%=currentUserObj.getStfID() %>
	 
	 <a href="/schoolmanagement/logOut.jsp">LogOut</a>
	 
</body>
</html>