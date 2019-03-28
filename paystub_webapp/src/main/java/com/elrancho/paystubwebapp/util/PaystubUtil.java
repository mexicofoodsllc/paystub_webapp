package com.elrancho.paystubwebapp.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elrancho.paystubwebapp.service.DbaServiceImpl;
import com.elrancho.paystubwebapp.service.PaystubServiceImpl;



@Service
public class PaystubUtil {
	
	@Autowired
	PaystubUtil ps;
	@Autowired
	PaystubServiceImpl psimpl;
	@Autowired
	DbaServiceImpl dbaimpl;
	@Autowired
	PaystubUtil psutil;
	//making any date user has selected to the next saturday
	
	public LocalDate dayConverter(LocalDate datePicker) {
			   
			   LocalDate saturdayDatepicker2=null;
			   String Day=datePicker.getDayOfWeek().name();
			   
			   switch(Day) {
			   
			   case "SUNDAY":saturdayDatepicker2 = datePicker.plusDays(6);
			   break;
			   case "MONDAY":saturdayDatepicker2 = datePicker.plusDays(5);
			   break;
			   case "TUESDAY":saturdayDatepicker2 = datePicker.plusDays(4);
			   break;
			   case "WEDNESDAY":saturdayDatepicker2 = datePicker.plusDays(3);
			   break;
			   case "THURSDAY":saturdayDatepicker2 = datePicker.plusDays(2);
			   break;
			   case "FRIDAY":saturdayDatepicker2 = datePicker.plusDays(1);
			   break;
			   case "SATURDAY":saturdayDatepicker2 = datePicker;
			   break;
			   
			   }
			return saturdayDatepicker2;
			
		}
	
	//list of amounts in $ corresponding to selected date
	public List<Float> curAmountGenerator(LocalDate datePicker){
		LocalDate saturdayDatepicker2 = ps.dayConverter(datePicker);
		
		 List<Float> currentAmount = psimpl.findCurrentAmount(saturdayDatepicker2);
		return currentAmount;
		
	}
	
	//list of dba types corresponding to selected date
	public List<String> dbaTypeGenerator(LocalDate datepicker){
		LocalDate saturdayDatepicker2 = ps.dayConverter(datepicker);
		
		//List of dba codes corresponding to the dates chosen by user
		   List<Integer> codeList = psimpl.findDbaCode(saturdayDatepicker2); 
		   List<String> dbaType = dbaimpl.findDbaType(codeList);
		   
		   dbaType.set(1,"Federal Income Tax") ;
		   dbaType.set(2,"Federal FICA Withheld") ;
		   dbaType.set(3, "Federal Medicare Withheld");
		
		return dbaType;
		
	}
	
	public float netPayGenerator(LocalDate date, List<Float> curAmount) {
		
		//initializing netPay to grossPay
		float netPay=curAmount.get(0);
		
		LocalDate saturdayDatepicker2 = ps.dayConverter(date);
		 //List of dba codes corresponding to the dates chosen by user
		   List<Integer> codeList = psimpl.findDbaCode(saturdayDatepicker2);
		   
		 //list of  description- Earning or deduction
		   List<String> dbaDesc = dbaimpl.findDbaDescription(codeList);
		   
		   for(int i=1;i<dbaDesc.size();i++) {
			   if(dbaDesc.get(i).contains("Earnings")) {
				   netPay=curAmount.get(0)+curAmount.get(i);
			   }
			   else if(dbaDesc.get(i).contains("Deductions")) {
				   netPay=netPay-curAmount.get(i);
			   }
		   }
		return netPay;
		
	}
	
	public int totalHoursGenerator(LocalDate date) {
		
		int totalHours=0;
		
		LocalDate saturdayDatepicker2 = ps.dayConverter(date);
		 List<Integer> hours = psimpl.findTotalHours(saturdayDatepicker2);
		 System.out.println("hours"+hours);
		 
		 for(Integer hour:hours) {
			 totalHours += hour;
		 }
		return totalHours;
		
	}

	
	/*public Map<String, String> earningGenerator(LocalDate date, List<Float> curAmount){
		LocalDate saturdayDatepicker2 = ps.dayConverter(date);
		//List of dba type corresponding to the dates chosen by user
		   List<String> typeList = psutil.dbaTypeGenerator(date);
		
		   List<Integer> codeList = psimpl.findDbaCode(saturdayDatepicker2);
		//list of  description- Earning or deduction
		   List<String> dbaDesc = dbaimpl.findDbaDescription(codeList);
		  //list to store earnings types
		   Map<String, String> earnings = new HashMap<String, String>();;
		 
		   for(int i=0;i<typeList.size();i++) {
			   if(dbaDesc.get(i).contains("Earnings")) {
				   earnings.put(typeList.get(i), "$"+curAmount.get(i));
			   }
		   }
		return earnings;
		
	}
	
	
	public Map<String, String> deductionGenerator(LocalDate date, List<Float> curAmount){
		LocalDate saturdayDatepicker2 = ps.dayConverter(date);
		//List of dba type corresponding to the dates chosen by user
		   List<String> typeList = psutil.dbaTypeGenerator(date);
		
		   List<Integer> codeList = psimpl.findDbaCode(saturdayDatepicker2);
		//list of  description- Earning or deduction
		   List<String> dbaDesc = dbaimpl.findDbaDescription(codeList);
		  //list to store earnings types
		   Map<String, String> deductions = new HashMap<String, String>();;
		 
		   for(int i=0;i<typeList.size();i++) {
			   if(dbaDesc.get(i).contains("Deductions")) {
				   deductions.put(typeList.get(i), "$"+curAmount.get(i));
			   }
		   }
		return deductions;
		
	}*/
	

}
