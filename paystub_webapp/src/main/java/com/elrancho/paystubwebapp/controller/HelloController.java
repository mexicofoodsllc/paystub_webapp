package com.elrancho.paystubwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elrancho.paystubwebapp.entity.Users;
import com.elrancho.paystubwebapp.service.EmployeeService;

@Controller
public class HelloController {

	 private EmployeeService employeeService;
	
	 
	 //returns index.jsp
   @RequestMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/login")
   public String sayHello(@RequestParam("username") String name, Model model) {
      model.addAttribute("username", name);
     // if(name=employeeService.findById())
      return "home";
   }
}
