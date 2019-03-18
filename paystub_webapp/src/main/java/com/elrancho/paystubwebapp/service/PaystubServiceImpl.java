package com.elrancho.paystubwebapp.service;

import java.time.LocalDate;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.elrancho.paystubwebapp.dao.PaystubRepository;
import com.elrancho.paystubwebapp.entity.Paystub;
import com.elrancho.paystubwebapp.entity.PaystubId;

@Service
public class PaystubServiceImpl implements PaystubService {
	
	@Autowired 
	private PaystubRepository paystubRepository;
	private Paystub ps;
	

	@Override
	public List<Paystub> findBypayPeriodEndDate(LocalDate date) {
		
		
		List<Paystub> paystubList = paystubRepository.findAll();
		
		//trying to fetch the contents of objects in paystubList but stuck there!
		
			for(Paystub p: paystubList) {
				System.out.println(p);
			}
			
		
		return paystubList;
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		
		return paystubRepository.count();
	}

	/*@Override
	public List<Paystub> findByPayDate(LocalDate date) {
		// TODO Auto-generated method stub
		LocalDate payPeriodEndDate = date;
		List<Paystub> paystubList = paystubRepository.findPayDateAndCurrentAmountAndDescription();
		System.out.println("********************"+paystubList.get(2));
		System.out.println("********************"+paystubList.get(3));
		return paystubList;
	}*/

}
