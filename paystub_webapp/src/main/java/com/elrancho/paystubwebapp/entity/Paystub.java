package com.elrancho.paystubwebapp.entity;


import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Paystub")
public class Paystub {
	
	@EmbeddedId private PaystubId id;
	
	String  dbaCode, currentAmount, ytdAmount,description;
	
	@Temporal(TemporalType.DATE)
	Date payPeriodEndDate;  
	@Temporal(TemporalType.DATE)
	Date checkDate; 
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPayPeriodEndDate() {
		return payPeriodEndDate;
	}
	public void setPayPeriodEndDate(Date payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}
	
	public PaystubId getId() {
		return id;
	}
	public void setId(PaystubId id) {
		this.id = id;
	}
	
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
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

	//overriding a toString method to get required String representation
	@Override
	public String toString() {
	    return "description: " + this.getDescription() + 
	           ", payPeriodEndDate: " + this.getPayPeriodEndDate()+ ", currentAmount:"+this.getCurrentAmount();
	}

}
