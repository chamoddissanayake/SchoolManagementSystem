<%@page import="com.itp.model.OBMember"%>
<%@page import="com.itp.model.Parent"%>
<%@page import="com.itp.model.Admin"%>
<%@page import="com.itp.model.AcademicStaff"%>
<%@page import="com.itp.model.AdministrativeStaff"%>
<%@page import="com.itp.model.Student"%>
<%@page import="com.itp.model.CustomError"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgotten Password</title>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	   	<script type="text/javascript" src="javascripts/loginUserType.js"></script>
	   	<link rel="stylesheet" type="text/css" href="stylesheets/general.css">
</head>
<body class="body1">

	<% CustomError EmailErr = (CustomError)request.getAttribute("EmailErr");
		if(EmailErr != null){
	%>

		<div style="background-color: #fe4c4c ; font-size: 25px ; text-align: center">
			<%=EmailErr.getDescription1() %>
		</div>
	<%
		}else{	}
	%>


	<% CustomError er = (CustomError)request.getAttribute("error");
		if(er != null){
	%>

		<div style="background-color: #fe4c4c ; font-size: 25px ; text-align: center">
			<%=er.getDescription1()+" => "+er.getName() %>
		</div>
	<%
		}else{	}
	%>
	
	
	<%
		Student stdobj = (Student)request.getAttribute("stdUserSent");
		AdministrativeStaff adsobj = (AdministrativeStaff)request.getAttribute("adstfSent");
		AcademicStaff acdsobj = (AcademicStaff)request.getAttribute("acdstfSent");
		Admin adminObj = (Admin)request.getAttribute("adminSent");
		Parent prnObj = (Parent)request.getAttribute("prnSent");
		OBMember obmObj = (OBMember)request.getAttribute("obmSent");
	
	if(stdobj != null){
	%>
		<div style="background-color: #33d7ff ; font-size: 25px ; text-align: center">
			<%="Password update link was sent to "+stdobj.getEmail()+" please update your password." %>
		</div>
	<% }else if(adsobj != null){ %>
		<div style="background-color: #33d7ff ; font-size: 25px ; text-align: center">
			<%="Password update link was sent to "+adsobj.getEmail()+" please update your password." %>
		</div>
	<% }else if(acdsobj != null){ %>
		<div style="background-color: #33d7ff ; font-size: 25px ; text-align: center">
			<%="Password update link was sent to "+acdsobj.getEmail()+" please update your password." %>
		</div>
	<% }else if(adminObj != null){ %>
		<div style="background-color: #33d7ff ; font-size: 25px ; text-align: center">
			<%="Password update link was sent to "+adminObj.getEmail()+" please update your password." %>
		</div>
	<% }else if(prnObj != null){ %>
		<div style="background-color: #33d7ff ; font-size: 25px ; text-align: center">
			<%="Password update link was sent to "+prnObj.getEmail()+" please update your password." %>
		</div>
	<% }else if(obmObj != null){ %>
		<div style="background-color: #33d7ff ; font-size: 25px ; text-align: center">
			<%="Password update link was sent to "+obmObj.getEmail()+" please update your password." %>
		</div>
	<% }else{ } %>
		<br>

<div style="text-align: center;">
	<img src="media/images/logo.png"  style ="height: auto;"  >
</div>
	
	
	
		<form action="ForgottenPassword" method="post">
		<fieldset class="centerForm" style=" border:4px groove; border-radius: 10px;width:400px "> 
		
		<div style="text-align: center;">
			<h3>Forgot Your Password?</h3>
		</div>
		<p>Don't worry, We can send password update link to your email.</p>
	
				<table>
				<col width="200">
				<tr>	
					<td>
						I am a :
					</td>
					<td>	
						<select name="user_type" id ="user_type">
						  <option value="student" selected>		Student					</option>
						  <option value="administrative_staff">	Administrative Staff	</option>
						  <option value="academic_staff">		Teacher					</option>
						  <option value="admin">				Admin					</option>
						  <option value="parent" >				Parent					</option>
						  <option value="ob_member">			OB Member				</option>
						</select>
					<td>
				</tr>
				</table>
		<br>

		<div class="uname_student box1">
				<table>
				<col width="200">
				<tr>		
					<td>	
							Enter Student ID: 				
					</td>
					<td>
							<input type="text" name="uname_student" 				id="uname_student" 				placeholder="Ex: S001">						
					</td>
				</tr>
				</table>		
		</div>
		<div class="uname_administrative_staff box1">
				<table>
				<col width="200">
				<tr>	
					<td>		
							Enter Administrative Staff ID: 	
					</td>
					<td>
							<input type="text" name="uname_administrative_staff" 	id="uname_administrative_staff" placeholder="Ex: STF001">						
					</td>
				</tr>
				</table>		
		</div>
		<div class="uname_academic_staff box1">
				<table>
				<col width="200">		
				<tr>
					<td>	
							Enter Teacher ID: 				
					</td>
					<td>
							<input type="text" name="uname_academic_staff" 			id="uname_academic_staff" 		placeholder="Ex: STF005">						
					</td>
				</tr>
				</table>		
		</div>

		<div class="uname_admin box1">
				<table>
				<col width="200">
				<tr>
					<td>	
							Enter Admin ID: 				
					</td>
					<td>
							<input type="text" name="uname_admin" 					id="uname_admin" 				placeholder="Ex: A001">						
					</td>
				</tr>
				</table>
		</div>
		<div class="uname_parent box1">
				<table>
				<col width="200">
				<tr>		
					<td>
							Enter Parent ID: 				
					</td>
					<td>
							<input type="text" name="uname_parent" 					id="uname_parent" 				placeholder="Ex: P001">						
					</td>
				</tr>
				</table>
		</div>
		<div class="uname_ob_member box1">
				<table>
				<col width="200">		
				<tr>
					<td>	
							Enter OB Member ID: 			
					</td>
					<td>	
							<input type="text" name="uname_ob_member" 				id="uname_ob_member" 			placeholder="Ex: OB001">					
					</td>
				</tr>
				</table>		
		</div>
		
		<div class="pwd box">
		<br>
				<table>
				<col width="200">
				<tr>
					<td>			
							Enter Email: 
					</td>
					<td>	
							<input type="email" name="uemail" id="uemail" placeholder="Provided email">			<br>
					</td>
				</tr>
				</table>		
		</div>
		<br>
	
		<div style="text-align: center;">
			<input type="submit" value="Send password update link to my mail" class="submitButton">
		</div>
		
		<br>
		
		
			<%
	Student std = new Student();
	AdministrativeStaff adstf = new AdministrativeStaff();
	AcademicStaff acdstf = new AcademicStaff();
	Admin admin = new Admin();
	Parent prn = new Parent();
	OBMember obm = new OBMember();
																																
	std=null;	adstf = null;	acdstf =null;	admin =null;	prn =null;	obm =null;						
																										
	if (request.getAttribute("stdUser") != null) {
	 	std = (Student) request.getAttribute("stdUser");
	}else if(request.getAttribute("adstfUser") != null){
		adstf = (AdministrativeStaff)request.getAttribute("adstfUser");
	}else if(request.getAttribute("acdstfUser") != null){
		acdstf = (AcademicStaff)request.getAttribute("acdstfUser");
	}else if(request.getAttribute("adminUser") != null){
		admin = (Admin)request.getAttribute("adminUser");
	}else if(request.getAttribute("prnUser") != null){
		prn =(Parent)request.getAttribute("prnUser"); 
	}else if(request.getAttribute("obUser") != null){
		obm= (OBMember)request.getAttribute("obUser");
	}
	
	%>
																																
	<% if(std!=null){%>
	<p class="worongInputMessage">
	<%="Your username or email incorrect. "%>
	</p>
	<script>
		var n="<%=std.getsId()%>"; 
		document.getElementById('uname_student').value = n;
		var e="<%=std.getEmail()%>"; 
		document.getElementById('uemail').value = e;
		document.getElementById('user_type').selectedIndex=0;
	</script>
	<%}else if(adstf != null){ %>
	<p class="worongInputMessage">
	<%="Your username or email incorrect. "%>
	</p>
	<script>
		var n="<%=adstf.getStfID()%>"; 
		document.getElementById('uname_administrative_staff').value = n;
		var e="<%=adstf.getEmail()%>"; 
		document.getElementById('uemail').value = e;
		document.getElementById('user_type').selectedIndex=1;
	</script>
	<% }else if(acdstf != null){%>
	<p class="worongInputMessage">
	<%="Your username or email incorrect. "%>
	</p>
	<script>
		var n="<%=acdstf.getStfID()%>"; 
		document.getElementById('uname_academic_staff').value = n;
		var e="<%=acdstf.getEmail()%>"; 
		document.getElementById('uemail').value = e;
		document.getElementById('user_type').selectedIndex=2;
	</script>	
	<% }else if(admin != null){%>
	<p class="worongInputMessage">
	<%="Your username or email incorrect. "%>
	</p>
	<script>
		var n="<%=admin.getaID()%>"; 
		document.getElementById('uname_admin').value = n;
		var e="<%=admin.getEmail()%>"; 
		document.getElementById('uemail').value = e;
		document.getElementById('user_type').selectedIndex=3;
	</script>	
	<% }else if(prn != null){%>
	<p class="worongInputMessage">
	<%="Your username or email incorrect. "%>
	</p>
	<script>
		var n="<%=prn.getPid()%>"; 
		document.getElementById('uname_parent').value = n;
		var e="<%=prn.getEmail()%>"; 
		document.getElementById('uemail').value = e;
		document.getElementById('user_type').selectedIndex=4;
	</script>		
	<%}else if(obm != null){ %>
	<p class="worongInputMessage">
	<%="Your username or email incorrect. "%>
	</p>
	<script>
		var n="<%=obm.getObID()%>"; 
		document.getElementById('uname_ob_member').value = n;
		var e="<%=obm.getEmail()%>"; 
		document.getElementById('uemail').value = e;
		document.getElementById('user_type').selectedIndex=5;
	</script>		
	<% }%>
	
		
		
		<br>
		<div style="text-align: center;">
			<a href="index.jsp">Go back to index.</a>
		</div>
		</fieldset>
	</form>
	
	
	
	
	

	
	
	
	
</body>
</html>