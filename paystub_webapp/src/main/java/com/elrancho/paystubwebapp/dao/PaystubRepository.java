package com.elrancho.paystubwebapp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elrancho.paystubwebapp.entity.Paystub;
import com.elrancho.paystubwebapp.entity.PaystubId;

public interface PaystubRepository extends JpaRepository<Paystub,PaystubId>{

}
