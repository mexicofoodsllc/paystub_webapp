package com.elrancho.paystubwebapp.service;


import java.util.List;

import com.elrancho.paystubwebapp.entity.Employee;


public interface EmployeeService {

	public boolean activeEmployeeCheck(int empid);
	List<Employee> getEmployeeDetails(int empid);
	
	
	
}
