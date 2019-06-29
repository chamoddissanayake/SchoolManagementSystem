<%@page import="com.itp.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>

<p>Welcome to Admin Dashboard.</p>
	
	<% Admin currentUserObj =(Admin)session.getAttribute("sessionUsr");%>
	 Welcome <%=currentUserObj.getaID() %>
	 
	 <a href="/SchoolManagementSystem/logOut.jsp">LogOut</a>

</body>
</html>