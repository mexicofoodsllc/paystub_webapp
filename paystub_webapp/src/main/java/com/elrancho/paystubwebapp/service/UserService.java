package com.elrancho.paystubwebapp.service;

import java.time.LocalDate;

public interface UserService {

	public void registerUser(int employeeId,int ssn,LocalDate dob,String pwd);
}
