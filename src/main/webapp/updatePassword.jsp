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
        <link rel="stylesheet" type="text/css" href="stylesheets/general.css">
	
</head>
<body class="body1" onload="bodyOnLoadFunction()">
    
        <div style="text-align: center;">
                <br>
                <img src="media/images/logo.png"  style ="height: auto;"  >
        </div>
    
	
	
	<form action="UpdatePassword" method="post" name="updatePasswordForm"  onsubmit = "return(validate());">
            <fieldset class="centerForm" style=" border:4px groove; border-radius: 10px;width:400px "> 
                <div style="text-align: center">
                    <h2>Update Password</h2>
                </div>
                
                <table>
		<col width="200">
                <tr>
                    <td>Your Account Type</td>
                        <td>
                                                <input type="text"	id="updateUserTypeV"                                    value="" >	<br>	<!-- visible  -->
                                                <input type="hidden"	id="updateUserType"		name="updateUserType"   value="" >	<br>	<!-- invisible  -->
                        </td>
                </tr>
                </table>
                
                <table>
		<col width="200">
                <tr>
                    <td>Your User ID:</td>
                        <td>
                                            <input type="text" 	id="updateUserIdV"                                      value="">	<br>	<!-- visible -->
                                            <input type="hidden"	id="updateUserId" 		name="updateUserId"     value="">	<br>    <!-- invisible -->
                        </td>
                </tr>
                </table>
                    
                <table>
		<col width="200">
                <tr>
                    <td>New password:</td>	
                        <td>
                                            <input type="password" 	id="updateUserPassword" 	name="updateUserPassword">		<br><br>
                        </td>
                </tr>
                </table>
                
                <table>
		<col width="200">
                <tr>
                    <td>ReEnter new password:</td>	
                        <td>
                                            <input type="password" 	id="updateReUserPassword" 	name="updateReUserPassword">            <br><br>
                        </td>
                </tr>
                </table>
                
            <div style="text-align: center;">    
		<input type="submit" value="Upadate my password" class="submitButton">
            </div>
            </fieldset>
        </form>
	

</body>
</html>