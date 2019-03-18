package com.elrancho.paystubwebapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elrancho.paystubwebapp.entity.Paystub;
import com.elrancho.paystubwebapp.service.PaystubServiceImpl;

@Controller
public class PaystubController {

	@Autowired
	PaystubServiceImpl psimpl;
	

	
	 @RequestMapping(value="/fetch_paystub")
	   public String fetchResult(@RequestParam("from") @DateTimeFormat(pattern="MM/dd/yyyy") LocalDate datepicker1,
			   @RequestParam("to") @DateTimeFormat(pattern="MM/dd/yyyy") LocalDate datepicker2, Model model) {
		   
		   model.addAttribute("datepicker1", datepicker1);
		   model.addAttribute("datepicker2", datepicker2);
		   LocalDate saturdayDatepicker2 = null;
		 
		   /*String fromDay=datepicker1.getDayOfWeek().name();
		   switch(fromDay) {
		   
		   case "SUNDAY":
			   model.addAttribute("saturdayDatepicker1", datepicker1.plusDays(6));
		   case "MONDAY": 
			   model.addAttribute("saturdayDatepicker1", datepicker1.plusDays(5));
		   case "TUESDAY":
			   model.addAttribute("saturdayDatepicker1", datepicker1.plusDays(4));
		   case "WEDNESDAY":
			   model.addAttribute("saturdayDatepicker1", datepicker1.plusDays(3));
		   case "THURSDAY":
			   model.addAttribute("saturdayDatepicker1", datepicker1.plusDays(2));
		   case "FRIDAY":
			   model.addAttribute("saturdayDatepicker1", datepicker1.plusDays(1));
		  
		   }*/
		   
		   //making any date user has selected to the next saturday
		   String toDay=datepicker2.getDayOfWeek().name();
		   switch(toDay) {
		   
		   case "SUNDAY":saturdayDatepicker2 = datepicker2.plusDays(6);
		   case "MONDAY":saturdayDatepicker2 = datepicker2.plusDays(5);
		   case "TUESDAY":saturdayDatepicker2 = datepicker2.plusDays(4);
		   case "WEDNESDAY":saturdayDatepicker2 = datepicker2.plusDays(3);
		   case "THURSDAY":saturdayDatepicker2 = datepicker2.plusDays(2);
		   case "FRIDAY":saturdayDatepicker2 = datepicker2.plusDays(1);
		   }
		   
		  /*List<Paystub> l = psimpl.findByPaystubId();
		   
		   Paystub gross = l.get(2);
		   Paystub net = l.get(3);*/
		 
		   model.addAttribute("gross", 100);
		   model.addAttribute("net", 200);
		   
		   List<Paystub> currentAmount = psimpl.findBypayPeriodEndDate(saturdayDatepicker2);
			return "paystubSummary";
		
	   }
	   @PostMapping("/paystubSummary")
	   public String paystubSummary() {
		   return "paystubSummary";
	   }
}
