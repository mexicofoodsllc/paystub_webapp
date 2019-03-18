package com.elrancho.paystubwebapp.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.elrancho.paystubwebapp.entity.Paystub;

public interface PaystubService {
	
	public List<Paystub> findBypayPeriodEndDate(LocalDate Date);
	public long count();
	//public List<Paystub> findByPayDate(LocalDate Date);
}
