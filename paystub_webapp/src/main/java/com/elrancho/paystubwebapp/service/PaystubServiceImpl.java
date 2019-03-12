package com.elrancho.paystubwebapp.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elrancho.paystubwebapp.dao.PaystubRepository;
import com.elrancho.paystubwebapp.entity.Paystub;

@Service
public class PaystubServiceImpl implements PaystubService {
	
	@Autowired 
	private PaystubRepository paystubRepository;

	@Override
	public List<Paystub> findByPaystubId() {

		return paystubRepository.findAll();
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		System.out.println("count");
		return paystubRepository.count();
	}

}
