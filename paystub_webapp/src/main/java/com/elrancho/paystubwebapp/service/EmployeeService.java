package com.elrancho.paystubwebapp.service;


import com.elrancho.paystubwebapp.entity.Employee;


public interface EmployeeService {

	
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	
}
