package com.elrancho.paystubwebapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elrancho.paystubwebapp.entity.Paystub;
import com.elrancho.paystubwebapp.service.PaystubServiceImpl;
import com.elrancho.paystubwebapp.util.PaystubUtil;


@Controller
public class HomeController {

	@Autowired
	PaystubServiceImpl psimpl;
	@Autowired
	PaystubUtil psutil;
	 
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
	   return "security_question";
   }
   
   @PostMapping("/home")
   public String getHome(Model model) {
	   
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
