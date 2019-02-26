package com.elrancho.paystubwebapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	int employeeId;
	
	String password;
	long ssn;
	String status;
	//String jobCode, status, hireDate, terminationDate, supervisorID, payMethod, hourlyRate, birthDate; 
	//String emailAddress, phone1, phone2, address1, address2, city;
	//String state, zipCode, gender, company, businessUnit, badgeNumber, payCategory;
	//String firstName, lastName;
	String username;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}