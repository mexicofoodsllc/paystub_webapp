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
		   
		   
		   List<Paystub> l = psimpl.findByPaystubId();
		   Paystub gross = l.get(2);
		   Paystub net = l.get(3);
		   
		   model.addAttribute("datepicker1", datepicker1);
		   model.addAttribute("datepicker2", datepicker2);
		   model.addAttribute("gross", gross);
		   model.addAttribute("net", net);
			return "paystubSummary";
		
	   }
	   @PostMapping("/paystubSummary")
	   public String paystubSummary() {
		   return "paystubSummary";
	   }
}
