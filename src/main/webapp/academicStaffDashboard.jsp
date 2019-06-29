<%@page import="com.itp.model.AcademicStaff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Academic Staff Dash Board</title>
</head>
<body>


<p>Welcome to Academic Staff Dashboard.</p>
	
	<% AcademicStaff currentUserObj =(AcademicStaff)session.getAttribute("sessionUsr");%>
	 Welcome <%=currentUserObj.getStfID() %>
	 
	 <a href="/SchoolManagementSystem/logOut.jsp">LogOut</a>

</body>
</html>