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
	int ssn;
	
	String password;
	LocalDate dob;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int employeeId, int ssn, String password, LocalDate dob) {
		this.employeeId = employeeId;
		this.ssn = ssn;
		this.password = password;
		this.dob = dob;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
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
		return "Users [employeeId=" + employeeId + ", ssn=" + ssn + ", password=" + password
				+ ", dob=" + dob + "]";
	} 
}
