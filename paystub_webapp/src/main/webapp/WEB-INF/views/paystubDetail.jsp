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

        .pay_div {
            color: #777;
            font: 20px "HelveticaNeue-Roman", sans-serif;
            margin: 50px 0;
        }
		
		 .paystub_btn{
        	    background-color: #ba150f;
    			margin: 50px;
   				color: white;
    			border: #eee;
    			padding: 23px;
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

        .custom-select {
            position: relative;
            font-family: Arial;
            width: 122px;
        }

        .custom-select select {
            display: none;
            /*hide original SELECT element:*/
        }

        .select-selected {
            background-color: #EC1313;
        }

        /*style the arrow inside the select element:*/

        .select-selected:after {
            position: absolute;
            content: "";
            top: 14px;
            right: 10px;
            width: 0;
            height: 0;
            border: 6px solid transparent;
            border-color: #fff transparent transparent transparent;
        }

        /*point the arrow upwards when the select box is open (active):*/

        .select-selected.select-arrow-active:after {
            border-color: transparent transparent #fff transparent;
            top: 7px;
        }

        /*style the items (options), including the selected item:*/

        .select-items div,
        .select-selected {
            color: #ffffff;
            padding: 8px 16px;
            border: 1px solid transparent;
            border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
            cursor: pointer;
            user-select: none;
        }

        /*style items (options):*/

        .select-items {
            position: absolute;
            background-color: #EC1313;
            top: 100%;
            left: 0;
            right: 0;
            z-index: 99;
        }

        /*hide the items when the select box is closed:*/

        .select-hide {
            display: none;
        }

        .select-items div:hover,
        .same-as-selected {
            background-color: rgba(0, 0, 0, 0.1);
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
                    <li><input type="submit" value="Paystub Detail" class="paystub_btn"/>
                    	
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                    	<a href="#" style="color:#ba150f;"><span style="color:#ba150f;" class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="jumbotron" style="height: 600px">
            <h3>View your Paystub details</h3>
            <!--surround the select box with a "custom-select" DIV element. Remember to set the width:-->
            <div class="custom-select">
                <select>
                    <option value="0">Select Date</option>
                    <option value="1">03/01/2019</option>
                    <option value="2">02/15/2019</option>
                </select>
            </div>
            <div id="paycheckAmount" class="pay_div">
                <table class="table table-hover">
                    <tbody>

                        <tr>
                            <td class="latestPaycheckLabel">Total Hours</td>
                            <td class="latestPaycheckNumber">10.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Total Earnings</td>
                            <td class="latestPaycheckNumber">$100.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Pre-Tax Deductions</td>
                            <td class="latestPaycheckNumber">$5.00</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">Taxes</td>
                            <td class="latestPaycheckNumber">$16.65</td>
                        </tr>
                        <tr>
                            <td class="latestPaycheckLabel">After-Tax Adjustments</td>
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
    <script>
        var x, i, j, selElmnt, a, b, c;
        /*look for any elements with the class "custom-select":*/
        x = document.getElementsByClassName("custom-select");
        for (i = 0; i < x.length; i++) {
            selElmnt = x[i].getElementsByTagName("select")[0];
            /*for each element, create a new DIV that will act as the selected item:*/
            a = document.createElement("DIV");
            a.setAttribute("class", "select-selected");
            a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
            x[i].appendChild(a);
            /*for each element, create a new DIV that will contain the option list:*/
            b = document.createElement("DIV");
            b.setAttribute("class", "select-items select-hide");
            for (j = 1; j < selElmnt.length; j++) {
                /*for each option in the original select element,
                create a new DIV that will act as an option item:*/
                c = document.createElement("DIV");
                c.innerHTML = selElmnt.options[j].innerHTML;
                c.addEventListener("click", function (e) {
                    /*when an item is clicked, update the original select box,
                    and the selected item:*/
                    var y, i, k, s, h;
                    s = this.parentNode.parentNode.getElementsByTagName("select")[0];
                    h = this.parentNode.previousSibling;
                    for (i = 0; i < s.length; i++) {
                        if (s.options[i].innerHTML == this.innerHTML) {
                            s.selectedIndex = i;
                            h.innerHTML = this.innerHTML;
                            y = this.parentNode.getElementsByClassName("same-as-selected");
                            for (k = 0; k < y.length; k++) {
                                y[k].removeAttribute("class");
                            }
                            this.setAttribute("class", "same-as-selected");
                            break;
                        }
                    }
                    h.click();
                });
                b.appendChild(c);
            }
            x[i].appendChild(b);
            a.addEventListener("click", function (e) {
                /*when the select box is clicked, close any other select boxes,
                and open/close the current select box:*/
                e.stopPropagation();
                closeAllSelect(this);
                this.nextSibling.classList.toggle("select-hide");
                this.classList.toggle("select-arrow-active");
            });
        }

        function closeAllSelect(elmnt) {
            /*a function that will close all select boxes in the document,
            except the current select box:*/
            var x, y, i, arrNo = [];
            x = document.getElementsByClassName("select-items");
            y = document.getElementsByClassName("select-selected");
            for (i = 0; i < y.length; i++) {
                if (elmnt == y[i]) {
                    arrNo.push(i)
                } else {
                    y[i].classList.remove("select-arrow-active");
                }
            }
            for (i = 0; i < x.length; i++) {
                if (arrNo.indexOf(i)) {
                    x[i].classList.add("select-hide");
                }
            }
        }
        /*if the user clicks anywhere outside the select box,
        then close all select boxes:*/
        document.addEventListener("click", closeAllSelect);
    </script>

</body>

</html>