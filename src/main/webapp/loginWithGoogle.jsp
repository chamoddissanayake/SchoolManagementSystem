<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Google Sign</title>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<meta name="google-signin-client_id" content="311182680505-ief7bq9i9e3q9pau97t4i0scba5jgcoe.apps.googleusercontent.com">
		<script src="https://apis.google.com/js/platform.js" async defer></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="javascripts/googlescript.js"></script>
		
		<style>
			.g-signin2{
				margin-left:700px;
                                margin-top:300px;
			}
			.data{
				display: none;
			}
		</style>
        
    </head>
    <body>
        
       	<div class="g-signin2" data-onsuccess="onSignIn"></div>


	<div class ="data">
		<p>Profile Details</p>
		<img id="pic" class="img-circle" width="100" height=100"/>
		<p>Email Address</p>
		<p id="email" class="alert alert-danger"></p>
		<button onclick="signOut()" class="btn btn-danger">Sign Out</button>

	</div>
        
        <div style="text-align: center">
            <br>
            <a href="index.jsp"> <--Go back</a>
        </div>
            
    </body>
</html>
