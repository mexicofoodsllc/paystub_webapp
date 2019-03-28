<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page isELIgnored="false" %>
    <title>Paystub Summary</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        .navbar-color {
            margin-top: 58px;
            padding: 1pc;
            font-size: 20px
        }

        h3 {
            font-size: 20px;
            color: #777;
            font: 22px "DINNextLTPro-Regular", sans-serif;
        }

		 .paystub_btn{
        	    background-color: #ba150f;
    			margin: 50px;
   				color: white;
    			border: #eee;
    			padding: 13px;
    			font-size: 15px;
        }
        .pay_div {
        	color: #777;
            font: 20px "HelveticaNeue-Roman", sans-serif;
            margin: 50px 0;
        }
		
		.jumbotron{
			background-color:#DAF7A6;
		}
		
        .nav>li:hover {
            /* background-color: #b85855; 
            background-color: #9c0702;*/
			background-color: transparent;
            opacity: 0.6 !important;
        }

       .latestPaycheckLabel,
       .latestPaycheckNumber {
       		font-size:15px;
       }

        .PaycheckLabel {
            font-weight: bold;
            font-size:15px;
        }

       td:nth-child(2) {
 			 text-align: left; /* NEW */
		}
       


        /* On screens that are 900px or less, set the background color to olive */
        @media screen and (max-width: 900px) {
            .pay_div {
                font-size: 15px;
            }
        }

         /* On screens that are 600px or less, set the background color to olive */
         @media screen and (max-width: 600px) {
            .pay_div {
                font-size: 13px;
            }
           
        }
    </style>
</head>

<body style="background-color:#DAF7A6">
	
    <nav class="navbar navbar-inverse navbar-static-top navbar-color" role="navigation" style="background-color:#DAF7A6">
        <div class="container">
            <div class="navbar-header">
				<img src="https://s3.amazonaws.com/wbd.employer-images/01984_logo_1522248608_v.jpg" width="200" height="142"/>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
                    <li>
                    	<form action="paystubSummary" method="post">
                    		<input type="submit" value="Paystub Summary" class="paystub_btn"/>
                    	</form>
                    </li>
				</ul>

                <ul class="nav navbar-nav navbar-right">
                   <li style="color:#ba150f;">
                    	<form action="/"> 
                    		<input type="submit" value="Logout" class="logout"/>
        				</form>
        			</li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container" style=",background-color:#DAF7A6">
        <div class="jumbotron" style="height: 100% ,background-color:#DAF7A6">  
            <div id="paycheckAmount" class="pay_div">
            	<p class="PaycheckLabel">Earnings&Deductions</p>
            	
                <table class="table table-hover"> 
                  <tr>
    				<th class="PaycheckLabel">Description</th>
    				<th class="PaycheckLabel">Current</th> 
   					<th class="PaycheckLabel">Hours</th>
    				<th class="PaycheckLabel">Year to Date</th>
 				  </tr>
                    <tbody>
                    	<c:forEach var="paystub" items="${paystubList}">
                    		<tr>
		                      	<td class="latestPaycheckLabel">${paystub.description}</td>
		                      	<td class="latestPaycheckNumber">${paystub.currentAmount}</td>
		                      	<td class="latestPaycheckLabel">${paystub.hours}</td>
		                      	<td class="latestPaycheckNumber">${paystub.ytdAmount}</td> 
		                	</tr> 
		                 </c:forEach>
                     </tbody>
                </table>
               <!--   <p class="PaycheckLabel">Taxes & Deductions</p>
                
               <table class="table table-hover">
                    <tbody>
                    	<c:if test="${not empty deductions}">
                    		<c:forEach var="deduction" items="${deductions}">
                    			<tr>
		                            <td class="latestPaycheckLabel"> ${deduction.key}</td>
		                         
		                           <td class="latestPaycheckLabel"> ${deduction.value}</td>
		              
		                    	  </tr> 
		                    </c:forEach>    
	                     </c:if>
          
                    </tbody>
                </table>--> 
                <p class="PaycheckLabel">Net Pay</p>
                <table class="table table-hover">
                	<tbody>
                		<tr>
                			<td class="latestPaycheckLabel">Net Pay</td>
                			<td class="latestPaycheckLabel">${NetPay}</td>
                		</tr>
                	</tbody>
                
                </table>
            </div>
            <a href="#" class="btn btn-success btn-lg">
      		<span class="glyphicon glyphicon-print"></span> Print 
    </a>
        </div>
        <div class="footer">
            <p>&copy ElRancho Supermercado</p>
        </div>
    </div>

</body>

</html>