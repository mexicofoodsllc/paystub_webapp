package com.elrancho.paystubwebapp.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elrancho.paystubwebapp.dao.EmployeeRepository;
import com.elrancho.paystubwebapp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//checking if an employee is active by 
	public boolean activeEmployeeCheck(int empid) {
		String status = null;
		boolean isActive=true;
		Iterable<Employee> emp = employeeRepository.findAll();
		
		for(Employee e: emp) {
			if(e.getEmployeeId()==empid){
				status = e.getStatus();
			}
		}
		if(status.equalsIgnoreCase("A")) //comparing with active flag "A" from employee table
				isActive=true;	
			else
				isActive=false;
		
		return isActive;
	}
	
	public List<Employee> getEmployeeDetails(int empid) {
	
		List<Employee> emp = employeeRepository.findAll();
		 
		return emp;
	}

	@Override
	public boolean securityQuestionCheck(LocalDate dob, String ssn) {
		boolean isSecurityQuestionTrue= false;
		List<Employee> emp = employeeRepository.findAll();
		System.out.println(emp);
		System.out.println("dob "+dob);
		for(Employee e: emp) {
			if((e.getBirthDate().equals(dob))&& (e.getSsn().equals(ssn))){
					isSecurityQuestionTrue=true;
				}
			}
		return isSecurityQuestionTrue;
	}



}
