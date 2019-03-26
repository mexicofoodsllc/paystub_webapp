package com.elrancho.paystubwebapp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elrancho.paystubwebapp.util.PaystubUtil;

@Controller
public class PaystubController {

	private LocalDate datePicker;
	String dbaDesc, dbaType;
	
	@Autowired
	PaystubUtil psutil;

	
	@PostMapping("/paystubSummary")
	   public String paystubSummary() {
		   return "paystubSummary";
	   }
	   
	 
	 @RequestMapping(value="/fetch_paystub")
	 
	   public String fetchResult(@RequestParam("to") @DateTimeFormat(pattern="MM/dd/yyyy") LocalDate datepicker2, Model model) {
		 
		   model.addAttribute("datepicker2", datepicker2);
		   datePicker = datepicker2;
		   
			 //List of current amounts corresponding to the dates chosen by user
		   List<Float> currentAmount = psutil.curAmountGenerator(datePicker);
		   model.addAllAttributes(currentAmount);
		  
		   float grossPay=currentAmount.get(0);
		   model.addAttribute("GrossPay", "$"+grossPay);
		   
		   float netPay = psutil.netPayGenerator(datePicker, currentAmount);
		   model.addAttribute("NetPay", "$"+netPay);
		   
		   List<String> dbaType = psutil.dbaTypeGenerator(datePicker);
		   model.addAllAttributes(dbaType);
 		   
		   int hours = psutil.totalHoursGenerator(datePicker);
		   model.addAttribute("hours", hours);
		   
		   return "paystubSummary";
		
	   }
	 

	   @GetMapping("/paystubDetail")
	   public ModelAndView paystubDetail() {
		   
		   List<Float> currentAmount = psutil.curAmountGenerator(datePicker);
		   ModelAndView model = new ModelAndView("paystubDetail");
		   //model.addObject("currentAmount",currentAmount);
		  
		   Map<String, Float> earnings = psutil.earningGenerator(datePicker, currentAmount);
		   model.addObject("earnings",earnings);
		 
		   Map<String, Float> deductions = psutil.deductionGenerator(datePicker, currentAmount);
		   System.out.println("deductions**************"+deductions);
		   model.addObject("deductions",deductions);

		   
		  /* List<Float> earningsAmt = psutil.earningAmountListGenerator(datePicker, currentAmount);
		   model.addObject("earningsAmt",earningsAmt);
		   
		   List<Float> deductionsAmt = psutil.deductionAmountListGenerator(datePicker, currentAmount);
		   model.addObject("deductionsAmt",deductionsAmt);*/
		     
		   float netPay = psutil.netPayGenerator(datePicker, currentAmount);
		   model.addObject("NetPay", "$"+netPay);
		 

		   return model;
	}
}
