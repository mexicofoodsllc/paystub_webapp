package com.elrancho.paystubwebapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * This class is a composite id for Paystub table
 * It can be embedded into Paystub.java and 
 * employeeId, payPeriodEndDate & Description act as composite primary keys.
 */

@Embeddable
public class PaystubId implements Serializable {
	
	private int employeeID;	
	@Temporal(TemporalType.DATE)
	Date payPeriodEndDate;
	private String description;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Date getPayPeriodEndDate() {
		return payPeriodEndDate;
	}
	public void setPayPeriodEndDate(Date payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
