package com.elrancho.paystubwebapp.service;


import com.elrancho.paystubwebapp.entity.Employee;


public interface EmployeeService {

	public boolean activeEmployeeCheck(int empid);
	public String generateUserName(int empid);
	
	
	
}
