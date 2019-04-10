package com.elrancho.paystubwebapp.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elrancho.paystubwebapp.entity.Employee;
import com.elrancho.paystubwebapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Employee> getEmployeeDetails() {
		
		List<Employee> emp = employeeRepository.findAll();
		 
		return emp;
	}
	
	//checking if an employee is active by 
	public boolean activeEmployeeCheck(int empid) {
		String status = null;
		boolean isActive=true;
		
		//Iterable<Employee> emp = getEmployeeDetails();
		Iterable<Employee> emp = employeeRepository.findByEmployeeId(empid);
		for(Employee e: emp) {
			if(e.getEmployeeId()==empid){
				status = e.getStatus();
			}
		}
		if(status.equalsIgnoreCase("A")) //comparing with active flag "A" from employee table
				isActive=true;	
			else
				isActive=false;
		System.out.println("isActive"+isActive);
		return isActive;
	}
	

	@Override
	public boolean securityQuestionCheck(LocalDate dob, String ssn) {
		boolean isSecurityQuestionTrue= false;
		//List<Employee> emp = getEmployeeDetails();
		List<Employee> emp = employeeRepository.findByBirthDateAndSsn(dob, ssn);
		System.out.println("emp"+emp);
		/*for(Employee e: emp) {
			if((e.getBirthDate().equals(dob))&& (e.getSsn().equals(ssn))){
					isSecurityQuestionTrue=true;
				}
			}*/
		if(!emp.isEmpty()) {
			isSecurityQuestionTrue = true;
		}
			
		
		return isSecurityQuestionTrue;
	}

	@Override
	public int getEmpIdWithDobSsn(LocalDate dob, String ssn) {
		List<Employee> emp = employeeRepository.findByBirthDateAndSsn(dob, ssn);
		int empId = 0;
		for(Employee e: emp) {
			if((e.getBirthDate().equals(dob))&& (e.getSsn().equals(ssn))){
					empId = e.getEmployeeId();
				}
			}
		return empId;
	}



}
