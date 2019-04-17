package com.elrancho.paystubwebapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.elrancho.paystubwebapp.entity.Paystub;
import com.elrancho.paystubwebapp.entity.Users;
import com.elrancho.paystubwebapp.service.PaystubServiceImpl;
import com.elrancho.paystubwebapp.service.UserServiceImpl;
import com.elrancho.paystubwebapp.util.PaystubUtil;


@Controller
public class HomeController {

	@Autowired
	PaystubServiceImpl psimpl;
	@Autowired
	PaystubUtil psutil;
	@Autowired
	UserServiceImpl usrimpl;
	
	private LocalDate datePicker;
	String dbaDesc, dbaType,password;
	int employeeId;
	Set<LocalDate> dateSet;
	 
	//returns index.jsp
   @RequestMapping("/login")
   public String login() {
      return "index";
   }
   
   @PostMapping("/register")
   public String registerEmployee() {
	   return "register";
   }
   
   @PostMapping("/forgotpwd")
   public String resetPassword() {
	   return "forgotpwdSecurityQuestions";
   }
   
   @PostMapping("/home") 
   public String getHome(@RequestParam("pwd") String pwd, Model model) {
	   
	   password = pwd;
	   boolean isPasswordValid = usrimpl.passwordValidator(pwd);
	   System.out.println("isPasswordValid " +isPasswordValid);
	  
	   if(isPasswordValid==false) {
		  String errMsg = "Your password is incorrect";
		  model.addAttribute("errMsg", errMsg);
		  return "index";
	  }
	   
	 
	   else {
		   
		   model.addAttribute("pwd", password);
		   employeeId = usrimpl.getEmpId(pwd);
		   System.out.println("employeeId "+employeeId);
		   // list of paystubs for employee with id employeeId
		   List<Paystub> paystubList = psimpl.getAllPaystubs(employeeId);
		   
		   //set containing unique dates from paystub list
		   Set<LocalDate> dateSet = psutil.getDates(paystubList);
		   model.addAttribute("dateSet",dateSet);
		   System.out.println("dateSet "+dateSet);

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
   
   @PostMapping("/paystubSummary")
   public String paystubSummary() {
	   return "paystubSummary";
   }
   
 
 @RequestMapping(value="/fetch_paystub")
 
   public String fetchResult(@RequestParam(value = "to") @DateTimeFormat(pattern="MM/dd/yyyy") LocalDate date, Model model) {
	 
	 //System.out.println("password"+pwd);  
	 model.addAttribute("datepicker2", date);
	   datePicker = date;
	   //List of current amounts corresponding to the dates chosen by user
	   List<Float> currentAmount = psutil.curAmountGenerator(datePicker,employeeId);
	   System.out.println("currentAmount "+currentAmount);
	   model.addAllAttributes(currentAmount);
	  
	   
	   //if(psutil.validDateCheck(datePicker)==true) {
		   float grossPay=currentAmount.get(0);
		   model.addAttribute("grossPay", grossPay);
		   
		   float netPay = psutil.netPayGenerator(datePicker,employeeId);
		   model.addAttribute("NetPay", "$"+netPay);

 		   
		   int hours = psutil.totalHoursGenerator(datePicker,employeeId);
		   model.addAttribute("hours", hours);
	  // }
	   
	   /*else if(psutil.validDateCheck(datePicker)==false) {
		   float grossPay= 0.0f;
		   model.addAttribute("grossPay", grossPay);
		   String errorMsg = "There is no payment for the week "+datePicker;
		   model.addAttribute("errorMsg", errorMsg);
	   }*/
	   
	   

	   
	   return "paystubSummary";
	
   }
 

   @GetMapping("/paystubDetail")
   public ModelAndView paystubDetail() { 
	   
	   ModelAndView model = new ModelAndView("paystubDetail");
	   
	   List<Paystub> paystubs = psimpl.findPaystubDetails(datePicker,employeeId);
	   model.addObject("paystubList",paystubs);

	   
	   List<Float> currentAmount = psutil.curAmountGenerator(datePicker,employeeId);
	   List<String> dbaDesc = psutil.dbaTypeGenerator(datePicker,employeeId);
	   model.addObject("dbaDesc",dbaDesc);
	   
	     
	   float netPay = psutil.netPayGenerator(datePicker,employeeId);
	   model.addObject("NetPay", "$"+netPay); 
	   
	   float ytoPay = psimpl.findTotalYrToPay(datePicker,employeeId);
	   model.addObject("ytoPay", "$"+ytoPay); 
	 

	   return model;
}
  
}

