package com.elrancho.paystubwebapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RegisterController {

	  @PostMapping("/regHome")
	   public String regHome(@RequestParam("empid") int empid, Model model) {
		   model.addAttribute("empid", empid);
		   return "paystubSummary";
	   }
	   
	 
}
