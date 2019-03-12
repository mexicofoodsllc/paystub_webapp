package com.elrancho.paystubwebapp.service;

import java.util.Date;
import java.util.List;

import com.elrancho.paystubwebapp.entity.Paystub;

public interface PaystubService {
	
	public List<Paystub> findById();
	public long count();

}
