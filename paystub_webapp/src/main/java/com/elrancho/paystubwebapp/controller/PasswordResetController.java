package com.elrancho.paystubwebapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elrancho.paystubwebapp.entity.Paystub;
import com.elrancho.paystubwebapp.entity.Users;
import com.elrancho.paystubwebapp.service.EmployeeServiceImpl;
import com.elrancho.paystubwebapp.service.PaystubServiceImpl;
import com.elrancho.paystubwebapp.service.UserServiceImpl;
import com.elrancho.paystubwebapp.util.PaystubUtil;

@Controller
public class PasswordResetController {
	
	
	private int employeeId;
	
	@Autowired
	EmployeeServiceImpl esimpl;
	@Autowired
	UserServiceImpl usimpl;
	@Autowired
	PaystubServiceImpl psimpl;
	@Autowired
	PaystubUtil psutil;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;	
	
	
	@PostMapping("/securityQnValidate")
	public String securityQnValidator(@RequestParam("dob") @DateTimeFormat(pattern="MM/dd/yyyy") LocalDate dob, @RequestParam("ssn") String ssn, Model model) {
		
		//validating security questions- dob and ssn 4 digits
		  boolean securityQuestionValid = esimpl.securityQuestionCheck(dob, ssn);
		  System.out.println("securityQuestionValid "+securityQuestionValid);
		
		  if(securityQuestionValid==false) {
			  String errMsgSecQuestion = "Please choose your correct date of birth and ssn";
			  model.addAttribute("errMsgSecQuestion", errMsgSecQuestion);
			  return "forgotpwdSecurityQuestions";
		  }
		  
		  else {
				  employeeId = esimpl.getEmpIdWithDobSsn(dob, ssn);
		
				  return "forgotpwdPasswordValidation";
		  }
	}
	
	@PostMapping("/pwdResetSuccess")
	public String resetPassword(@RequestParam("pwd1") String pwd, Model model) {
		
		  //password encryption
		    String encodedPassword = bCryptPasswordEncoder.encode(pwd);
		  
		  //setting new user fields
		    Users user= new Users(employeeId, encodedPassword);
	      //registering new user in users table
		    usimpl.registerUser(user);
		
		    List<Paystub> paystubList = psimpl.getAllPaystubs(employeeId);
		  //set containing unique dates from paystub table
			  Set<LocalDate> dateSet = psutil.getDates(paystubList);
			  model.addAttribute("dateSet",dateSet);

		   //grossPayList has all the grossPays in the table
			  List<Float> grossPayList = new ArrayList<Float>();
			  for(LocalDate d:dateSet) {
				grossPayList.add(psutil.grossPayGenerator(d,employeeId));
				   
			  }
		   
			  model.addAttribute("grossPayList",grossPayList);
		   
			  List<Float> netPayList = new ArrayList<Float>();
		  
			  for(LocalDate d:dateSet) {
				   
				netPayList.add(psutil.netPayGenerator(d,employeeId));
				   
			   }
			   model.addAttribute("netPayList",netPayList);
		   
			   List<Integer> hoursList = new ArrayList<Integer>();
			  
			  for(LocalDate d:dateSet) {
				hoursList.add(psutil.totalHoursGenerator(d,employeeId));
				   
			   }
			 model.addAttribute("hoursList",hoursList);
			 return "paystubSummary";  
		  }


}
