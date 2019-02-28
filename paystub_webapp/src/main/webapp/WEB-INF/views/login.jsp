<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Employee Login</title>
</head>
<body>
   <div class="container">
   
  	<h2 style="text-align:center"><strong>Login to View, Download and Print your PayStub</strong></h2>
  	
  <div class="jumbotron">
  
    <form action="login" method="post">
    <div class="form-group">
     User Name<input type="text" name="username" class="form-control" placeholder="Username" required/>
    </div>
    <div class="form-group">
     Password  <input type="password" name="pwd" maxLength="6" class="form-control" placeholder="Password" required/>
          </div>
           <div class="form-group"> 
              <input type="submit" value="Login" class="btn btn-primary btn-block"/>
           </div>
    
   </form>
   
   	<div class="bottom-container">
	  	<a href="/register.jsp" class="btn btn-primary btn-default">Register</a>
	  	<a href="#" class="btn btn-primary btn-danger">Forgot password?</a>
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