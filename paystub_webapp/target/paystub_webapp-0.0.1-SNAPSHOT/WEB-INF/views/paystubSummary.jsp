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
	$( function() {
	    $( "#datepicker1" ).datepicker();
	     } );
	$( function() {
	    $( "#datepicker2" ).datepicker();
	  } );
	
	$(document).ready(function(){
		$('.table-row-hide').click(function() {
		  $(".table-row-hide").show();
		  $(this).hide();
		});
	});
	/*$(document).ready(function(){
		$( "table" ).on( "click", "tr", function() {
			location.href = "http://ec2-3-90-133-23.compute-1.amazonaws.com:8080/paystub_webapp/paystubDetail.jsp";
			});
	});*/
  	</script>
    
    <style>
    .navbar-color {
            background-color: #eee;
            margin-top: 60px;
            padding: 1pc;
            font-size: 20px
        }
        
        
		.calenderdiv_style{
			width: 40%;
			color: #777;
            font: 15px "HelveticaNeue-Roman", sans-serif;
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
        	    float: right;
        	    position: relative;
        	    bottom: 500px;
        	    right: 170px;
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
        
        .table-row-hide{
			/*cursor: pointer;
			display:none;*/
		}
        
        
        
         body{
        background-image:url("https://png.pngtree.com/thumb_back/fw800/back_pic/00/06/36/6856299993ea2f8.jpg")
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
                bottom: 315px;
                right: 10%;
                 
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
    

    <div class="container">
        <div class="jumbotron" style="height: 600px">
            
            <div class="calenderdiv_style">
				<form action="fetch_paystub" method="post">
            		<p id="calenderTitle">View paychecks from:</p>
	            	<input type="text" id="datepicker1" name="from"/>
	            	<p>to</p>
	            	<input type="text" id="datepicker2" name="to"/>
	            	<input type="submit" value="Paystub Summary" class="paystub_btn"/>
	            </form>
			</div>

          
	      </div>

			
			
           <div id="paycheckAmount" class="pay_div">
            	
                 <table class="table table-hover">
				  <thead>
				    <tr>
				    	<th>PAY DATE</th>
     					<th>PAY PERIOD</th>
     					<th>GROSS PAY</th>
				    </tr>
				  </thead>
				  <tbody>
					    
					  <tr class="table-row-hide">
						<td class="latestPaycheckLabel">${datepicker2}</td>
						<td class="latestPaycheckLabel">${datepicker1} - ${datepicker2}</td>
						<td class="latestPaycheckNumber">$${gross}</td>
						 <td><form action="paystubDetail"><input type="submit" value="Paystub Detail" /></form></td>
					    </tr>
					   
				  </tbody>
				  </table>
            </div>
           
        </div>
        <div class="footer">
            <p>&copy ElRancho Supermercado</p>
        </div>
</body>

</html>
