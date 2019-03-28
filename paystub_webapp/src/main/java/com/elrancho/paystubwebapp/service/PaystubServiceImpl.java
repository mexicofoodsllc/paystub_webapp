package com.elrancho.paystubwebapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elrancho.paystubwebapp.dao.PaystubRepository;
import com.elrancho.paystubwebapp.entity.Paystub;

@Service
public class PaystubServiceImpl implements PaystubService {
	
	@Autowired 
	private PaystubRepository paystubRepository;
	

	//method to get the current Amount corresponding to the date passed from controller
	@Override
	public List<Float> findCurrentAmount(LocalDate date) {
		List<Float> curAmount = new ArrayList<>();
		Iterable<Paystub> paystubs = paystubRepository.findAll();
				
		//selecting the currentAmount corresponding to the dates selected by user and adding it to the list curAmount
		for(Paystub paystub: paystubs) {
			if(date.equals(paystub.getPayPeriodEndDate())) {
				curAmount.add(paystub.getCurrentAmount());
			}
						
		}
		return curAmount;
	}

	@Override
	public List<Integer> findDbaCode(LocalDate date) {
		List<Integer> dbaCode = new ArrayList<>();
		Iterable<Paystub> paystubs = paystubRepository.findAll();
		for(Paystub paystub: paystubs) {
			if(date.equals(paystub.getPayPeriodEndDate())) {
				dbaCode.add(paystub.getDbaCode());
			}

		}
		return dbaCode;
	}

	@Override
	public List<Integer> findTotalHours(LocalDate date) {
		List<Integer> hoursList = new ArrayList<Integer>();
		Iterable<Paystub> paystubs = paystubRepository.findAll();
		for(Paystub paystub: paystubs) {
			if(date.equals(paystub.getPayPeriodEndDate())) {
				
				hoursList.add(paystub.getHours());
			}

		}
		return hoursList;
	}

	@Override
	public List<Paystub> findPaystubDetails(LocalDate Date) {
		Iterable<Paystub> paystubs = paystubRepository.findAll();
		List<Paystub> ps= new ArrayList<Paystub>();
		//selecting the currentAmount corresponding to the dates selected by user and adding it to the list curAmount
		for(Paystub paystub: paystubs) {
			if(Date.equals(paystub.getPayPeriodEndDate())) {
				ps.add(paystub);
			}
						
		}
		return ps;
	}

	@Override
	public Float findTotalYrToPay(LocalDate date) {
		Float TotalYearToPay = 0.0f;
		Iterable<Paystub> paystubs = paystubRepository.findAll();
		for(Paystub paystub: paystubs) {
			if(date.equals(paystub.getPayPeriodEndDate())) {
				
				TotalYearToPay += TotalYearToPay+ paystub.getYtdAmount();
			}
		}

		
		return TotalYearToPay;
	}


}
