<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<!-- Static content -->
	<link rel="stylesheet" href="/resources/css/style.css">
	<script type="text/javascript" src="/resources/js/app.js"></script>
	
	<title>Employee Login</title>
	<style>

		.margin{
		    margin-top: 100px;
		}
		.button_style{
        	
        	background-color: #EC1313;
        	color:white;
        	border-color: #EC1313;
        }
        body{
        background-image:url("http://testosteronelawsuitg.info/wp-content/uploads/2018/11/light-blue-star-background-light-blue-star-background-design-2.jpg")
        }
	</style>
</head>

<body>
   <div class="container">

  	
  <div class="jumbotron margin">
  <img src="https://s3.amazonaws.com/wbd.employer-images/01984_logo_1522248608_v.jpg" width="200" height="200"/>
    <form action="login" method="post">
    	<h3>Employee Login</h3>
    	<p>Login to View, Download and Print your PayStub</p>
	    <div class="form-group">
	     	User Name<input type="text" name="username" class="form-control" placeholder="Username" required/>
	    </div>
    	<div class="form-group">
     		Password  <input type="password" name="pwd" maxLength="6" class="form-control" placeholder="Password" required/>
        </div>
        <div class="form-group"> 
              <input type="submit" value="Login" class="btn btn-primary btn-default button_style"/>
        </div>
     </form>
   
   	<div class="bottom-container">
   		<form action="/register" method="post">
   			<div class="form-group">
	  			<input type="submit"class="btn btn-primary btn-default button_style" value="Register"/>
	  		</div>
	  	</form>
	  	<form action="/pwdmanagement" method="post">
	  		<div class="form-group">
	  			<input type="submit"class="btn btn-primary btn-danger" value="Forgot Password?"/>
	  		</div>
	  	</form>
	</div>
  </div>
  <div class="footer">
   <p>&copy ElRancho Supermercado</p>
  </div>
 </div>
 <script src="https://chancejs.com/chance.min.js"></script>
    <!-- Latest compiled and minified CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <!-- jQuery library -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <!-- Latest compiled JavaScript -->
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
 <script src="main.js"></script>

</body>
</html>