package com.elrancho.paystubwebapp.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Paystub")
public class Paystub {
	
	@EmbeddedId private PaystubId id;
	
	String description;
	int employeeId, dbaCode, hours;
	float currentAmount, ytdAmount;

	LocalDate payPeriodEndDate;  
	
	LocalDate checkDate; 
	
	
	
	public PaystubId getId() {
		return id;
	}



	public void setId(PaystubId id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public int getDbaCode() {
		return dbaCode;
	}



	public void setDbaCode(int dbaCode) {
		this.dbaCode = dbaCode;
	}



	public int getHours() {
		return hours;
	}



	public void setHours(int hours) {
		this.hours = hours;
	}



	public float getCurrentAmount() {
		return currentAmount;
	}



	public void setCurrentAmount(float currentAmount) {
		this.currentAmount = currentAmount;
	}



	public float getYtdAmount() {
		return ytdAmount;
	}



	public void setYtdAmount(float ytdAmount) {
		this.ytdAmount = ytdAmount;
	}



	public LocalDate getPayPeriodEndDate() {
		return payPeriodEndDate;
	}



	public void setPayPeriodEndDate(LocalDate payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}



	public LocalDate getCheckDate() {
		return checkDate;
	}



	public void setCheckDate(LocalDate checkDate) {
		this.checkDate = checkDate;
	}



	@Override
	public String toString() {
		return "Paystub [currentAmount=" + currentAmount + ", description=" + description +", dbaCode=" + dbaCode +", hours=\" + hours +]"; 
	}


	
	
}
