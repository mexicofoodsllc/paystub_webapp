package com.elrancho.paystubwebapp.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaystubController {

	@RequestMapping("/get_time")
	@ResponseBody  //the method return value is bound to the web response body in httpresponse (not to jsp view).
	public String getServerTime() {
		Date d = new Date(); 
		return d.toString();
		
	}
	
	 @RequestMapping(value="/fetch")
	 @ResponseBody
	   public void fetchResult(@RequestParam("from") @DateTimeFormat(pattern="MM/dd/yyyy") Date datepicker1) {
		   System.out.println("**************" +datepicker1);
		   //System.out.println("**************" +to);
		   
			//return datepicker1.toString() ;
		
	   }
}
