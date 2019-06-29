<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Password</title>

	<script>	
		
	      // Form validation code
	      function validate() {
	    	//Check new password empty
		         if( document.updatePasswordForm.updateUserPassword.value == "" ) {
			            alert( "Please new password" );
			            document.updatePasswordForm.updateUserPassword.focus() ;
			            return false;
		         }
		         //Check new Re-password empty
		         if( document.updatePasswordForm.updateReUserPassword.value == "" ) {
			            alert( "Please re Enter your password to confirm" );
			            document.updatePasswordForm.updateReUserPassword.focus() ;
			            return false;
		         }
		       //Check both are same
		       	if(document.updatePasswordForm.updateUserPassword.value != document.updatePasswordForm.updateReUserPassword.value ) {
			            alert( "Password and reEnter password does not match" );
			            document.updatePasswordForm.updateReUserPassword.focus() ;
			            return false;
		         }
	         return( true );
	      }
		
	</script>

	<script>
	function bodyOnLoadFunction() {
		var urlStr = window.location.href;
		var url = new URL(urlStr);
		var type = url.searchParams.get("type");
		var id =  url.searchParams.get("id");
			
		document.getElementById("updateUserType").value=type;
		document.getElementById("updateUserId").value=id;
		
		document.getElementById("updateUserTypeV").value=type;
		document.getElementById("updateUserIdV").value=id;
		document.getElementById("updateUserTypeV").disabled = true;
		document.getElementById("updateUserIdV").disabled = true;
	}
	</script>
	
</head>
<body onload="bodyOnLoadFunction()">
	<p>Update Password</p>
	
	<form action="UpdatePassword" method="post" name="updatePasswordForm"  onsubmit = "return(validate());">
								<input type="hidden"	id="updateUserType"			name="updateUserType" value="" >				<br>	<!-- invisible  -->
		Account Type			<input type="text"		id="updateUserTypeV"							  value="" >				<br>	<!-- visible  -->
								<input type="hidden"	id="updateUserId" 			name="updateUserId" value="">					<br>    <!-- invisible -->
		User ID:				<input type="text" 		id="updateUserIdV" 								value="">					<br>	<!-- visible -->
		New password:			<input type="password" 	id="updateUserPassword" 	name="updateUserPassword">						<br>
		ReEnter new password:	<input type="password" 	id="updateReUserPassword" 	name="updateReUserPassword">					<br>
		
		<input type="submit" value="Upadate my password">
	</form>
	

</body>
</html>