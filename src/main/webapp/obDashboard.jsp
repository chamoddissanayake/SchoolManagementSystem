<%@page import="com.itp.model.OBMember"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OB Dashboard</title>
</head>
<body>


	<p>Welcome to OB Dashboard.</p>
	
	<% OBMember currentUserObj =(OBMember)session.getAttribute("sessionUsr");%>
	 Welcome <%=currentUserObj.getObID() %>
	 
	 <a href="/schoolmanagement/logOut.jsp">LogOut</a>
	 
	 
</body>
</html>