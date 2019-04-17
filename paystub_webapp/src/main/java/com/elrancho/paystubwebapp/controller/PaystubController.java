package com.elrancho.paystubwebapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elrancho.paystubwebapp.entity.Paystub;
import com.elrancho.paystubwebapp.service.DbaServiceImpl;
import com.elrancho.paystubwebapp.service.PaystubServiceImpl;
import com.elrancho.paystubwebapp.util.PaystubUtil;

@Controller
public class PaystubController {

	/*private LocalDate datePicker;
	String dbaDesc, dbaType;
	
	@Autowired
	PaystubUtil psutil;
	@Autowired
	PaystubServiceImpl psimpl;
	@Autowired
	DbaServiceImpl dbaimpl;
	
	@PostMapping("/paystubSummary")
	   public String paystubSummary() {
		   return "paystubSummary";
	   }
	   
	 
	 @RequestMapping(value="/fetch_paystub")
	 
	   public String fetchResult(@RequestParam("to") @DateTimeFormat(pattern="MM/dd/yyyy") LocalDate datepicker2, Model model) {
		 
		 //System.out.println("password"+pwd);  
		 model.addAttribute("datepicker2", datepicker2);
		   datePicker = datepicker2;
		   //List of current amounts corresponding to the dates chosen by user
		   List<Float> currentAmount = psutil.curAmountGenerator(datePicker);
		   model.addAllAttributes(currentAmount);
		  
		   if(psutil.validDateCheck(datePicker)==true) {
			   float grossPay=currentAmount.get(0);
			   model.addAttribute("grossPay", grossPay);
			   
			   float netPay = psutil.netPayGenerator(datePicker);
			   model.addAttribute("NetPay", "$"+netPay);

	 		   
			   int hours = psutil.totalHoursGenerator(datePicker);
			   model.addAttribute("hours", hours);
		   }
		   
		   else if(psutil.validDateCheck(datePicker)==false) {
			   float grossPay= 0.0f;
			   model.addAttribute("grossPay", grossPay);
			   String errorMsg = "There is no payment for the week "+datePicker;
			   model.addAttribute("errorMsg", errorMsg);
		   }
		   
		   

		   
		   return "paystubSummary";
		
	   }
	 

	   @GetMapping("/paystubDetail")
	   public ModelAndView paystubDetail() { 
		   
		   ModelAndView model = new ModelAndView("paystubDetail");
		   
		   List<Paystub> paystubs = psimpl.findPaystubDetails(datePicker);
		   model.addObject("paystubList",paystubs);

		   
		   List<Float> currentAmount = psutil.curAmountGenerator(datePicker);
		   List<String> dbaDesc = psutil.dbaTypeGenerator(datePicker);
		   model.addObject("dbaDesc",dbaDesc);
		   
		     
		   float netPay = psutil.netPayGenerator(datePicker);
		   model.addObject("NetPay", "$"+netPay); 
		   
		   float ytoPay = psimpl.findTotalYrToPay(datePicker);
		   model.addObject("ytoPay", "$"+ytoPay); 
		 

		   return model;
	}*/
}
