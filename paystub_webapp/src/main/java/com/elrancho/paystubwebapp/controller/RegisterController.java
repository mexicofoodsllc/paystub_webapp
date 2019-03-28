package com.elrancho.paystubwebapp.controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elrancho.paystubwebapp.entity.Users;
import com.elrancho.paystubwebapp.service.EmployeeServiceImpl;
import com.elrancho.paystubwebapp.service.UserServiceImpl;

@Controller
public class RegisterController {
	
	private int employeeId;
	
	@Autowired
	EmployeeServiceImpl esimpl;
	@Autowired
	UserServiceImpl usimpl;


	  @PostMapping("/regmanagement")
	   public String regHome(@RequestParam("empid") int empId) {
		  
		  employeeId=empId;
		 boolean isActive= esimpl.activeEmployeeCheck(employeeId);
		 if(isActive==true){
		  return "security_question";
		 }
		 else {
			 return "error";
		 }
	   }
	   
	  @PostMapping("/empRegSucess")
	  public String paystubHome(@RequestParam("dob") @DateTimeFormat(pattern="MM/dd/yyyy") LocalDate dob,
			  					@RequestParam("ssn") int ssn, @RequestParam("pwd1") String pwd) {
		  
		  if(esimpl.activeEmployeeCheck(employeeId)==true) {

			  usimpl.registerUser(employeeId, ssn, dob, pwd);
		  }
		return "paystubSummary";
	  }
	 
}
