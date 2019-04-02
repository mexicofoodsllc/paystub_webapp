package com.elrancho.paystubwebapp.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elrancho.paystubwebapp.entity.Employee;
import com.elrancho.paystubwebapp.entity.Paystub;
import com.elrancho.paystubwebapp.entity.Users;
import com.elrancho.paystubwebapp.service.EmployeeServiceImpl;
import com.elrancho.paystubwebapp.service.PaystubServiceImpl;
import com.elrancho.paystubwebapp.service.UserServiceImpl;
import com.elrancho.paystubwebapp.util.PaystubUtil;

@Controller
public class RegisterController {
	
	private int employeeId;
	
	@Autowired
	EmployeeServiceImpl esimpl;
	@Autowired
	UserServiceImpl usimpl;
	@Autowired
	PaystubServiceImpl psimpl;
	@Autowired
	PaystubUtil psutil;
	

	  @PostMapping("/regmanagement")
	   public String regHome(@RequestParam("empid") int empId, Model model) {
		  
		  employeeId=empId;

		 boolean isActiveEmployee= esimpl.activeEmployeeCheck(employeeId);
		 boolean isActiveUser = usimpl.activeUserCheck(employeeId);

		 if(isActiveUser==true) {
			 return "activeUser";
		 }
		 
		 else if(isActiveEmployee==true){
			 return "security_question";
		 }
		 else 
			 return "terminatedUser";
	   }
	   
	  @PostMapping("/empRegSucess")
	  public String paystubHome(@RequestParam("dob") @DateTimeFormat(pattern="MM/dd/yyyy") LocalDate dob,
			  					@RequestParam("ssn") int ssn, @RequestParam("pwd1") String pwd, Model model) {
		  
		  /*password encryption
		  String encPwd = usimpl.hashPassword(pwd);
		  System.out.println(encPwd);*/
		  //setting new user fields
		  Users user= new Users(employeeId, ssn, pwd, dob);
		  //registering new user in users table
		  usimpl.registerUser(user);

		   List<Paystub> paystubList = psimpl.getAllPaystubs();
		   model.addAttribute("paystubs", paystubList);
		   
		   //set containing unique dates from paystub table
		   Set<LocalDate> dateSet = psutil.getDates();
		   model.addAttribute("dateSet",dateSet);

		   //grossPayList has all the grossPays in the table
		   List<Float> grossPayList = new ArrayList<Float>();
		   for(LocalDate d:dateSet) {
			 grossPayList.add(psutil.grossPayGenerator(d));
			   
		   }
		   
		   model.addAttribute("grossPayList",grossPayList);
		   
		  List<Float> netPayList = new ArrayList<Float>();
		  
		  for(LocalDate d:dateSet) {
			   
			netPayList.add(psutil.netPayGenerator(d));
			   
		   }
		   model.addAttribute("netPayList",netPayList);
		   
		   List<Integer> hoursList = new ArrayList<Integer>();
			  
			  for(LocalDate d:dateSet) {
				hoursList.add(psutil.totalHoursGenerator(d));
				   
			   }
			   model.addAttribute("hoursList",hoursList);
		   
	       return "paystubSummary";

	  }
	 
}
