package com.elrancho.paystubwebapp.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Users")
public class Users {

	@NotNull
	@Id
	int employeeId;
	String password;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int employeeId, String password) {
		this.employeeId = employeeId;
		this.password = password;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [employeeId=" + employeeId + ", password=" + password + "]";
	} 
}
