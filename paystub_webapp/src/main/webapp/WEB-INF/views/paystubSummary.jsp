<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="com.elrancho.paystubwebapp.service.PaystubServiceImpl"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Paystub Summary</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
     <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
  	<link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	
  	
    
    <style>
    .navbar-color {
            margin-top: 60px;
            padding: 1pc;
            font-size: 20px;
        }
        
      .navbar-inverse {
			border-color:white;
		}

		.calenderdiv_style{
			width: 40%;
			color: #777;
            font: 15px "HelveticaNeue-Roman", sans-serif;
		}
		.jumbatron{
			-webkit-box-shadow: 0px 3px 11px 2px rgba(0,0,0,0.2) !important;
   			-moz-box-shadow: 0px 3px 11px 2px rgba(0,0,0,0.2) !important;
   			box-shadow: 0px 3px 11px 2px rgba(0,0,0,0.2) !important;
		}
        
		 .paystub_btn{
        	    background-color: #ba150f;
    			margin: 50px;
   				color: white;
    			border: #eee;
    			padding: 13px;
    			font-size: 15px;
        }
        

        .pay_div{
        	    color: #777;
            	font: 15px "HelveticaNeue-Roman", sans-serif;
            
        }
		
	   .pay_span{
		padding: 15px;
		margin:10px;
		}
		
		.pay_period{
			margin: 28px;
		}
		
		.net_pay{
		 margin: 31px;
		 }
        
        h2{
        	    color: #ba150f;
    			
        }
        
        .table {
   			 width: 60%;
   		}
   		
        th{
       		width:110px;
        }

        .noPay{
        	background-color: yellow;
   			width: 50%;
   			border-style: solid;
  			border-color: black;
  			padding:10px;
        }
        .logout{
		
		  }
        

        .nav>li:hover {
            /* background-color: #b85855; 
            background-color: #9c0702;*/
            background-color: transparent;
            opacity: 0.6 !important;
        }

     

        .latestPaycheckNetPayLabel,
        .latestPaycheckNetPayNumber {
            font-weight: bold;
            width:110px;
        }

       .selectedPaystyle{
       	    border-top: none;
       }
      .hidden{
       	display:none;
       }
		
        /* On screens that are 900px or less (tablet), set the background color to olive */
        @media screen and (max-width: 900px) {
            .pay_div {
                font-size: 18px;
            }
        }

         /* On screens that are 600px(mobile) or less, set the below properties */
         @media screen and (max-width: 600px) {
            .pay_div {
                font-size: 15px;
                bottom: 315px;
                right: 10%;
                 
 			}
        }
    </style>
    
    <script>
  	
	/*$( function() {
	    $( "#datepicker1" ).datepicker();
	     } );*/
	$( function() {
	    $( "#datepicker2" ).datepicker();
	  } );

   
	  /*  $(function() { //shorthand document.ready function
            //$('#paySelected').hide();
	        $('#dateForm').submit(function() { //use on if jQuery 1.7+
	            //e.preventDefault();  //prevent form from submitting
	            $('#totalPaySummary').addClass("hidden")
	            $('#paySelected').removeClass("hidden");
	        });
	    });*/
	    
	   $(function() { //shorthand document.ready function
            //$('#paySelected').hide();
	        $('#dateForm').submit(function() { //use on if jQuery 1.7+
	           // e.preventDefault();  //prevent form from submitting
	            $('#totalPaySummary').addClass("hidden")
	            $('#paySelected').removeClass("hidden");
	        });
	    }); 
  	</script>

</head>

<body>
    <nav class="navbar navbar-inverse navbar-static-top navbar-color" role="navigation" style="background-color:white">
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
            	
                <h2><strong>Paystub Home</strong></h2>
                 
            	<ul class="nav navbar-nav navbar-right">
                    <li style="color:#ba150f;" class="fas fa-user-circle">
                    	<form action="/"> 
                    		<input type="submit" value="Logout" class="logout"/>
        				</form>
        			</li>
             	</ul>
            </div>
        </div>
    </nav>
    

    <div class="container">
        <div class="jumbotron">
            
            <div class="calenderdiv_style">
				<form action="fetch_paystub" id="dateForm" method="post">
            		<!-- <p id="calenderTitle">View paychecks from:</p>
	            	<input type="text" id="datepicker1" name="from"/>-->
	            	<p id="calenderTitle">Select date to view Pay stub details:</p> 
	            	<input type="text" id="datepicker2" name="to" required/>
	            	 <!-- <select name="date">
     					<c:forEach var="date" items="${dateSet}">
         					<option value="${date}">${date}</option>
     					</c:forEach>
 					</select> -->
	            	<input type="submit" value="View Paystub Summary"  class="paystub_btn" id="paystubSummary"/>
	            </form>
			</div>
			
           <div id="totalPaySummary" class="pay_div">
            	
                 <table class="table table-hover">
				  <thead>
				    <tr>
				    	<th>PAY DATE</th>
     					<th>GROSS PAY</th>
     					<th>NET PAY</th>
     					<th>HOURS</th>
				    </tr>
				  </thead>
				  <tbody>
					 <c:forEach var="date" items="${dateSet}"  varStatus="status">
						  <tr>
							<td class="latestPaycheckLabel"><a href="paystubDetail.jsp"></a>${date}</td>
							<td class="latestPaycheckNumber">$${grossPayList[status.index]}</td>
							<td class="latestPaycheckNumber">$${netPayList[status.index]}</td>
							<td class="latestPaycheckNumber">${hoursList[status.index]}</td>
						  </tr>
						</c:forEach>

				  </tbody>
				  </table>
            </div>
            
            <div id="paySelected" class="pay_div hidden">
            	 <table class="table">
				  <thead>
				    <tr>
				    	<th>PAY DATE</th>
     					<th>GROSS PAY</th>
     					<th>NET PAY</th>
     					<th>HOURS</th>
				    </tr>
				  </thead>
				  <tbody>
					<c:if test="${grossPay ne 0}">    
						 
						<tr class="table-row-hide">
							<td class="latestPaycheckLabel selectedPaystyle">${datepicker2}</td>
							<td class="latestPaycheckNumber selectedPaystyle">${grossPay}</td>
							<td class="latestPaycheckNumber selectedPaystyle">${NetPay}</td>
							<td class="latestPaycheckNumber selectedPaystyle">${hours}</td>
							 <td class="latestPaycheckNumber selectedPaystyle">
							 	<form action="paystubDetail">
							 		<input type="submit" value="Paystub Detail" />
							 	</form>
							 </td>
					    </tr>
						  
					 </c:if> 
				  </tbody>
				  </table>
				  <c:if test="${grossPay eq 0}"> 
					 	<div class="noPay">
					 		${errorMsg}
					 	</div>
				  </c:if>
            </div>
           </div>
           <div class="footer">
            	<p>&copy ElRancho Supermercado</p>
           </div>
        </div>

</body>

</html>
