<!DOCTYPE html>
<html lang="en">

<head>
    <title>Paystub Summary</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        .navbar-color {
            background-color: #eee;
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
    			padding: 23px;
        }
        .pay_div {
            color: #777;
            font: 20px "HelveticaNeue-Roman", sans-serif;
            margin: 50px 0;
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

       


        /* On screens that are 900px or less, set the background color to olive */
        @media screen and (max-width: 900px) {
            .pay_div {
                font-size: 18px;
            }
        }

         /* On screens that are 600px or less, set the background color to olive */
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
				<ul class="nav navbar-nav">
                    <li>
                    	<form action="/paystubSummary" method="post">
                    		<input type="submit" value="Paystub Summary" class="paystub_btn"/>
                    	</form>
                    </li>
				</ul>

                <ul class="nav navbar-nav navbar-right">
                    <li>
                    	<a href="#" style="color:#ba150f;"><span style="color:#ba150f;" class="glyphicon glyphicon-log-out"></span> Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="jumbotron" style="height: 100%">
            <h3>View your Paystub details</h3>
           
            <div id="paycheckAmount" class="pay_div">
                <table class="table table-hover">
                    <tbody>


                        <tr>
                            <td class="latestPaycheckLabel">Total Earnings</td>
                            <td class="latestPaycheckNumber">$100.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Overtime 1.5</td>
                            <td class="latestPaycheckNumber">10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Federal Income Tax</td>
                            <td class="latestPaycheckNumber">$5.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Federal FICA Withheld</td>
                            <td class="latestPaycheckNumber">$16.65</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">401(K) LOAN</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Accident</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Adj (Reg)</td>
                            <td class="latestPaycheckNumber">$5.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Adj. (OT)</td>
                            <td class="latestPaycheckNumber">$16.65</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Bonus</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Bonus A</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">BuyUp</td>
                            <td class="latestPaycheckNumber">$16.65</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Child Life</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">CorePlan Ins</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Critical Ill</td>
                            <td class="latestPaycheckNumber">$5.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Den High All</td>
                            <td class="latestPaycheckNumber">$16.65</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Den Low All</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">LTD</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Meal Reimbursement</td>
                            <td class="latestPaycheckNumber">$16.65</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Mileage Reimbursement</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Misc.</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">OneTime HrAd</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Other</td>
                            <td class="latestPaycheckNumber">$10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckNetPayLabel">Net Pay</td>
                            <td class="latestPaycheckNetPayNumber">$68.35</td>
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