<%@ page import="com.elrancho.paystubwebapp.service.PaystubServiceImpl"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Paystub Summary</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	
  	<script>
<<<<<<< HEAD
  	var toDate = $("#datepicker2").val();
=======
	var toDate = $("#datepicker2").val();
>>>>>>> 0cc47e9d182fd043fbaedadd403e90f9d0ee1a01
	$( function() {
	    $( "#datepicker1" ).datepicker();
	    
	  } );
	$( function() {
	    $( "#datepicker2" ).datepicker();
	  } );
	
	$("#datepicker2").focusout(function(){
			$.ajax({
				type:'Get',
				url:'fetch',
				data : "datepicker2=" + toDate,    
			    success : function(response) {    
				      alert(response);     
				     },    
				error : function(e) {    
				      alert('Error: ' + e);     
				     } 
			});
	});
	
	
  	
  	</script>
    <style>
    .navbar-color {
            background-color: #eee;
            margin-top: 60px;
            padding: 1pc;
            font-size: 20px
        }
        
        


        .pay_header{
        	font-weight:bold;
        }
        

        .pay_div{
        	    float: right;
        	    position: relative;
        	    bottom: 126px;
        	    right: 170px;
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
        
        table-row{
			cursor: pointer !important;
		
		}
        
        
        
         body{
        background-image:url("http://testosteronelawsuitg.info/wp-content/uploads/2018/11/light-blue-star-background-light-blue-star-background-design-2.jpg")
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
                 
 			}
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-inverse navbar-static-top navbar-color" role="navigation">
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
                    <li><a href="#"  style="color:#ba150f;"><span class="glyphicon glyphicon-log-out"  style="color:#ba150f;"></span> Logout</a></li>
             	</ul>
            </div>
        </div>
    </nav>
    
<<<<<<< HEAD
=======

>>>>>>> 0cc47e9d182fd043fbaedadd403e90f9d0ee1a01
    <div class="container">
        <div class="jumbotron" style="height: 600px">
        	<div>
           	 <h3>Welcome ${username},</h3>
           	</div>
            
            <div>
<<<<<<< HEAD
            		<p id="calenderTitle">View paychecks from:</p>
	            	<input type="text" id="datepicker1" />
	            	<p>to</p>
	            	<input type="text" id="datepicker2"/>
			</div>
=======
            	<p id="calenderTitle">View paychecks from:</p>
	        <input type="text" id="datepicker1" />
	        <p>to</p>
	        <input type="text" id="datepicker2"/>
	           
	  </div>
>>>>>>> 0cc47e9d182fd043fbaedadd403e90f9d0ee1a01
			
			
           <div id="paycheckAmount" class="pay_div">
            	
                 <table class="table table-hover">
				  <thead>
				    <tr>
				    	<th>PAY DATE</th>
     					<th>PAY PERIOD</th>
     					<th>GROSS PAY</th>
     					<th>NET PAY</th>
				    </tr>
				  </thead>
				  <tbody>
					    
					  <tr class="table-row" style="cursor: pointer">
						<td class="latestPaycheckLabel">12/12/2012</td>
						<td class="latestPaycheckLabel">12/06/2012 - 12/12/2012</td>
						<td class="latestPaycheckNumber">$68.35</td>
						 <td class="latestPaycheckNumber">$50</td>
						 
					    </tr>
				  </tbody>
				  </table>
            </div>
           
        </div>
        <div class="footer">
            <p>&copy ElRancho Supermercado</p>
        </div>
    </div>

</body>

</html>
