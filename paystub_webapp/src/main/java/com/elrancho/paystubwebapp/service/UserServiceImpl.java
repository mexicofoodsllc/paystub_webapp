package com.elrancho.paystubwebapp.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elrancho.paystubwebapp.dao.UsersRepository;
import com.elrancho.paystubwebapp.entity.Employee;
import com.elrancho.paystubwebapp.entity.Users;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	EmployeeServiceImpl esimpl;	
	
	@Override
	public String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	
	}

	@Override
	public void registerUser(Users user) {
		
		usersRepository.save(user);
		
	}

	@Override
	public boolean activeUserCheck(int empid) {
		boolean isActive=true;
		Iterable<Users> userList = usersRepository.findAll();
		for(Users u:userList) {
			if(u.getEmployeeId()==empid) {
				isActive=true;
			}
			else
				isActive=false;
		}
	
		return isActive;
	}


	

	

	
}
