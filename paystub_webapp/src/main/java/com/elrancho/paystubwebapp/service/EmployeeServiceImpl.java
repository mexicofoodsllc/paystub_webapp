package com.elrancho.paystubwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.elrancho.paystubwebapp.dao.EmployeeRepository;
import com.elrancho.paystubwebapp.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	//constructor injection for EmployeeRepository
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public Employee findById(int theId) {
		Employee theEmployee = employeeRepository.findOne(theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);
	}

}
