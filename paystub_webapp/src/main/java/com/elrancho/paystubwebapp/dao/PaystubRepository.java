package com.elrancho.paystubwebapp.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.elrancho.paystubwebapp.entity.Paystub;
import com.elrancho.paystubwebapp.entity.PaystubId;

public interface PaystubRepository extends JpaRepository<Paystub,PaystubId>{
	
	//@Query(value = "SELECT payPeriodEndDate, currentAmount, description FROM Paystub")
	//List<Paystub>findPayDateAndCurrentAmountAndDescription();
	
	
}
