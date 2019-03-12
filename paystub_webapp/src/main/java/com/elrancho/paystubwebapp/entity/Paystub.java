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
	String checkControl, dbaCode, currentAmount, ytdAmount;
	@Temporal(TemporalType.DATE)
	Date checkDate; 
	

	public PaystubId getId() {
		return id;
	}
	public void setId(PaystubId id) {
		this.id = id;
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
