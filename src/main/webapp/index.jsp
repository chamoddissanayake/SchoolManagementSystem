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
 		<title>Login</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	   	<script type="text/javascript" src="javascripts/loginUserType.js"></script>  
	
	   	<link rel="stylesheet" type="text/css" href="stylesheets/general.css">
	   	
	  	
 		<script>	
		
	      // Form validation code
	      function validate() {
	    	//Check new password empty
		         if( document.loginForm.upassword.value == "" ) {
			            alert( "Please password" );
			            document.loginForm.upassword.focus() ;
			            return false;
		         }
		       
	         return( true );
	      }
		
	</script>
	  
</head>
<body class="body1">

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
		Student stdObj = (Student)request.getAttribute("StdEdited");
		AdministrativeStaff adstfObj = (AdministrativeStaff)request.getAttribute("adstfEdited");
		AcademicStaff acdstfObj = (AcademicStaff)request.getAttribute("acdsEdited");
		Admin adminfObj = (Admin)request.getAttribute("adminEdited");
		Parent prnObj = (Parent)request.getAttribute("prnEdited");
		OBMember obmObj = (OBMember)request.getAttribute("obmEdited");
		
		if(stdObj != null){
	%>
		<div style="background-color: #33beff ; font-size: 25px ; text-align: center">
			<%=stdObj.getsId()+", Your password was updated successfully." %>
		</div>
	<% }else if(adstfObj != null){ %>
		<div style="background-color: #33beff ; font-size: 25px ; text-align: center">
			<%=adstfObj.getStfID()+", Your password was updated successfully." %>
		</div>
	<% }else if(acdstfObj != null){ %>
		<div style="background-color: #33beff ; font-size: 25px ; text-align: center">
			<%=acdstfObj.getStfID()+", Your password was updated successfully." %>
		</div>
	<% }else if(adminfObj != null){ %>
		<div style="background-color: #33beff ; font-size: 25px ; text-align: center">
			<%=adminfObj.getaID()+", Your password was updated successfully." %>
		</div>
	<% }else if(prnObj != null){ %>
		<div style="background-color: #33beff ; font-size: 25px ; text-align: center">
			<%=prnObj.getPid()+", Your password was updated successfully." %>
		</div>
	<% }else if(obmObj != null){ %>
		<div style="background-color: #33beff ; font-size: 25px ; text-align: center">
			<%=obmObj.getObID()+", Your password was updated successfully." %>
		</div>
	<% }else {}  %>
	
<div style="text-align: center;">
	<br>
	<img src="media/images/logo.png"  style ="height: auto;"  >
</div>

	<form action="Login" method="post" name="loginForm" onsubmit = "return(validate());">
		<fieldset class="centerForm" style=" border:4px groove; border-radius: 10px;width:400px "> 
		<div style="text-align: center;">	
			<h2>Login</h2>
		</div>
				<table>
				<col width="200">
				<tr>		
					<td>		I am a :
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
					</td>
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
			
				<br>			
			<div class="pwd box">
				<table>
				<col width="200">
				<tr>	
					<td>		
								Enter Password:
					</td>
					<td> 
								<input type="password" name="upassword" id="upassword" >	
					</td>
				</tr>
				</table>	
	
			</div>
			<br>		
		<div style="text-align: center;">
			<input type="submit" value="Login" class="submitButton">
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
			<%="Your username or password incorrect. Please retry. "%>
			</p>
			<script>
				var n="<%=std.getsId()%>"; 
				document.getElementById('uname_student').value = n;
				var p="<%=std.getPassword()%>"; 
				document.getElementById('upassword').value = p;
				document.getElementById('user_type').selectedIndex=0;
			</script>
			<%}else if(adstf != null){ %>
			<p class="worongInputMessage">
			<%="Your username or password incorrect. Please retry. "%>
			</p>
			<script>
				var n="<%=adstf.getStfID()%>"; 
				document.getElementById('uname_administrative_staff').value = n;
				var p="<%=adstf.getPassword()%>"; 
				document.getElementById('upassword').value = p;
				document.getElementById('user_type').selectedIndex=1;
			</script>
			<% }else if(acdstf != null){%>
			<p class="worongInputMessage">
			<%="Your username or password incorrect. Please retry."%>
			</p>
			<script>
				var n="<%=acdstf.getStfID()%>"; 
				document.getElementById('uname_academic_staff').value = n;
				var p="<%=acdstf.getPassword()%>"; 
				document.getElementById('upassword').value = p;
				document.getElementById('user_type').selectedIndex=2;
			</script>	
			<% }else if(admin != null){%>
			<p class="worongInputMessage">
			<%="Your username or password incorrect. Please retry. "%>
			</p>
			<script>
				var n="<%=admin.getaID()%>"; 
				document.getElementById('uname_admin').value = n;
				var p="<%=admin.getPassword()%>"; 
				document.getElementById('upassword').value = p;
				document.getElementById('user_type').selectedIndex=3;
			</script>	
			<% }else if(prn != null){%>
			<p class="worongInputMessage">
			<%="Your username or password incorrect. Please retry."%>
			</p>
			<script>
				var n="<%=prn.getPid()%>"; 
				document.getElementById('uname_parent').value = n;
				var p="<%=prn.getPassword()%>"; 
				document.getElementById('upassword').value = p;
				document.getElementById('user_type').selectedIndex=4;
			</script>		
			<%}else if(obm != null){ %>
			<p class="worongInputMessage">
			<%="Your username or password incorrect. Please retry."%>
			</p>
			<script>
				var n="<%=obm.getObID()%>"; 
				document.getElementById('uname_ob_member').value = n;
				var p="<%=obm.getPassword()%>"; 
				document.getElementById('upassword').value = p;
				document.getElementById('user_type').selectedIndex=5;
			</script>		
			<% }%>
		
		<div style="text-align: center;">
		<br>
			<a href="loginWithGoogle.jsp" style="text-decoration: none;">I am a guest.</a>
		</div>
                        
		<div style="text-align: center;">
		<br>
			<a href="forgottenPassword.jsp" style="text-decoration: none;">Forgotten my password.</a>
		</div>
			
	
		</fieldset>
	</form>
</body>
</html>