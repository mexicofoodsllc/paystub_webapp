package com.elrancho.paystubwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	 
	 //returns index.jsp
   @RequestMapping("/")
   public String login() {
      return "index";
   }
   
   @PostMapping("/register")
   public String registerEmployee() {
	   return "register";
   }
   
   @PostMapping("/forgotpwd")
   public String resetPassword() {
	   return "security_question";
   }
   
   @PostMapping("/home")
   public String getHome() {
      return "paystubSummary";
   }
   
 
}
