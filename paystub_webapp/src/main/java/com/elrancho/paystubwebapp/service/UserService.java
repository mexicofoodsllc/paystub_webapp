package com.elrancho.paystubwebapp.service;



import com.elrancho.paystubwebapp.entity.Users;

public interface UserService {

	String hashPassword(String plainTextPassword);
	public void registerUser(Users user);
	public boolean activeUserCheck(int empid);
}
