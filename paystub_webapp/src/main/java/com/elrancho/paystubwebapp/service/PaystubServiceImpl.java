package com.elrancho.paystubwebapp.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.elrancho.paystubwebapp.dao.PaystubRepository;
import com.elrancho.paystubwebapp.entity.Paystub;

@Service
public class PaystubServiceImpl implements PaystubService {
	
	@Autowired 
	private PaystubRepository paystubRepository;

	
	Model model;

	@Override
	public List<Paystub> findByPaystubId() {
		
		List<Paystub> paystubList = paystubRepository.findAll();
		
		System.out.println("********************"+paystubList.get(2));
		System.out.println("********************"+paystubList.get(3));
		//model.addAttribute("Gross Pay", paystubList.)

		return paystubList;
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		//System.out.println("count");
		return paystubRepository.count();
	}

}
