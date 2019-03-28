package com.elrancho.paystubwebapp.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elrancho.paystubwebapp.dao.UsersRepository;
import com.elrancho.paystubwebapp.entity.Users;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	EmployeeServiceImpl esimpl;
	Users user;
	
	public void registerUser(int employeeId,int ssn,LocalDate dob,String pwd) {
		//System.out.println("Username"+esimpl.generateUserName(employeeId));
		 // user.setUsername(esimpl.generateUserName(employeeId));
		  user.setEmployeeId(employeeId);
		  user.setDob(dob);
		  user.setSsn(ssn);
		  user.setPassword(pwd);
		  usersRepository.save(user);
	}
	

	
}
