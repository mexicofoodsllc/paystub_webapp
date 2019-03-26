package com.elrancho.paystubwebapp.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.elrancho.paystubwebapp.entity.Paystub;

public interface PaystubService {
	

	public List<Float> findCurrentAmount(LocalDate Date);
	public List<Integer> findDbaCode(LocalDate Date);
	public List<Integer> findTotalHours(LocalDate Date);

}
