<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<!-- Static content -->
	<link rel="stylesheet" href="/resources/css/style.css">
	<script type="text/javascript" src="/resources/js/app.js"></script>
	
	<title>Reset Password</title>
</head>

<body>
   <div class="container">
   
  	<h2 style="text-align:center"><strong>Reset your password here</strong></h2>
  	
  <div class="jumbotron">
  
    <form action="/" method="post">
	    <div class="form-group">
	     	Date of Birth(mm/dd/yyyy)<input type="text" name="dob" class="form-control" placeholder="Date of Birth" required/>
	    </div>
    	<div class="form-group">
     		Last 4 digits of SSN<input type="text" name="ssn" maxLength="4" class="form-control" placeholder="Last 4 digits of SSN" required/>
        </div>
        <div class="form-group">
     		New Password  <input type="password" name="pwd1" maxLength="6" class="form-control" placeholder="New Password" required/>
        </div>
        <div class="form-group">
     		Confirm Password  <input type="password" name="pwd2" maxLength="6" class="form-control" placeholder="Confirm Password" required/>
        </div>
        <div class="form-group"> 
              <input type="submit" value="Reset Password" class="btn btn-primary btn-block"/>
         </div>
     </form>
   
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