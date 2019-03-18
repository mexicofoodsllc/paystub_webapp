package com.elrancho.paystubwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elrancho.paystubwebapp.service.PaystubServiceImpl;


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
   
   @PostMapping("/pwdmanagement")
   public String resetPassword() {
	   return "resetpwd";
   }
   
   @PostMapping("/home")
   public String sayHello(@RequestParam("username") String name, Model model) {
      model.addAttribute("username", name);
      return "paystubSummary";
   }
   
   @GetMapping("/paystubDetail")
   public String paystubDetail() {
	   return "paystubDetail";
   }
 
}
