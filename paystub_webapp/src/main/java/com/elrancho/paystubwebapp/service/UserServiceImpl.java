package com.elrancho.paystubwebapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.elrancho.paystubwebapp.dao.UsersRepository;
import com.elrancho.paystubwebapp.entity.Users;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	EmployeeServiceImpl esimpl;	


	@Override
	public void registerUser(Users user) {
		
		usersRepository.save(user);
		
	}

	@Override
	public boolean activeUserCheck(int empid) {
		boolean isActive=false;
		Iterable<Users> userList = usersRepository.findAll();
		for(Users u:userList) {
			System.out.println("userList"+u);
			if(u.getEmployeeId()==empid) {
				isActive=true;
			}
			else
				isActive=false;
		}
	
		return isActive;
	}

	@Override
	public boolean passwordValidator(String password) {
		boolean isValid = false;
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Iterable<Users> userList = usersRepository.findAll();
		for(Users u:userList) {
			if(encoder.matches(password, u.getPassword())) {
				isValid=true;
				//System.out.println("u.getPassword()  "+u.getEmployeeId());
				
			}
		}
		
		
		return isValid;
	}

	@Override
	public int getEmpId(String password) {
		Iterable<Users> userList = usersRepository.findAll();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		int eId = 0;
		for(Users u:userList) {
			if(encoder.matches(password, u.getPassword())) {
				eId=u.getEmployeeId();
			}
		}
		return eId;
	}


	

	

	
}
