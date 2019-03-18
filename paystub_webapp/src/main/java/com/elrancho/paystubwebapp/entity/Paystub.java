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
	
	String  dbaCode, currentAmount, ytdAmount,description;
	
	
	LocalDate payPeriodEndDate;  
	
	LocalDate checkDate; 
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getPayPeriodEndDate() {
		return payPeriodEndDate;
	}
	public void setPayPeriodEndDate(LocalDate payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}
	
	public PaystubId getId() {
		return id;
	}
	public void setId(PaystubId id) {
		this.id = id;
	}
	
	public LocalDate getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(LocalDate checkDate) {
		this.checkDate = checkDate;
	}
	public String getDbaCode() {
		return dbaCode;
	}
	public void setDbaCode(String dbaCode) {
		this.dbaCode = dbaCode;
	}

	public String getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(String currentAmount) {
		this.currentAmount = currentAmount;
	}
	public String getYtdAmount() {
		return ytdAmount;
	}
	public void setYtdAmount(String ytdAmount) {
		this.ytdAmount = ytdAmount;
	}
	@Override
	public String toString() {
		return "Paystub [currentAmount=" + currentAmount + ", description=" + description + ", payPeriodEndDate="
				+ payPeriodEndDate + "]";
	}


	
	
}
