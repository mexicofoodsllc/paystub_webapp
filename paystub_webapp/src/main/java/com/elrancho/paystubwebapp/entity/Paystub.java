package com.elrancho.paystubwebapp.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Paystub")
public class Paystub {
	
	
	@Id
	int employeeID;	
	String checkControl, dbaCode, description, currentAmount, ytdAmount;
	@Temporal(TemporalType.DATE)
	Date payPeriodEndDate;
	@Temporal(TemporalType.DATE)
	Date checkDate;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Date getpayPeriodEndDate() {
		return payPeriodEndDate;
	}
	public void setPayPeriod(Date payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}
	
	public String getCheckControl() {
		return checkControl;
	}
	public void setCheckControl(String checkControl) {
		this.checkControl = checkControl;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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


}
