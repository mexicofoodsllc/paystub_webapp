package com.elrancho.paystubwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elrancho.paystubwebapp.dao.EmployeeRepository;
import com.elrancho.paystubwebapp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public boolean activeEmployeeCheck(int empid) {
		
		boolean isActive=true;
		Iterable<Employee> emp = employeeRepository.findAll();
		
		for(Employee e: emp) {
			if(e.getEmployeeId()==empid) {
				isActive=true;
			}
			else
				isActive=false;
		}
		return isActive;
	}
	
	public String generateUserName(int empid) {
		String userName=null;
		String fName=null,lName=null;
		Iterable<Employee> emp = employeeRepository.findAll();
		for(Employee e: emp) {
			if(e.getEmployeeId()==empid) {
				 fName = e.getFirstName();
				 lName = e.getLastName();
			}
				userName=fName+lName.charAt(0);
		}
		return userName;
	}
}
