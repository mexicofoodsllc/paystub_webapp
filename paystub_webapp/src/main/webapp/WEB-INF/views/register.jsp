<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Employee Registration</title>
</head>
<body>
   <div class="container">
   
  	<h2 style="text-align:center"><strong>Register to View, Download and Print your PayStub</strong></h2>
  	
  <div class="jumbotron">
  
    <form action="/" method="post">
    <div class="form-group">
     Employee ID<input type="text" name="empid" class="form-control" placeholder="Employee ID" required/>
    </div>
    <div class="form-group">
     Password  <input type="password" name="pwd" maxLength="6" class="form-control" placeholder="Password" required/>
     </div>
     <div class="form-group">
     Confirm Password  <input type="password" name="pwd" maxLength="6" class="form-control" placeholder="Password" required/>
     </div>
           <div class="form-group"> 
              <input type="submit" value="Register" class="btn btn-primary btn-block"/>
           </div>
  
   </form>
  </div> 
</div> 
  <div class="footer">
   <p>&copy ElRancho Supermercado</p>
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