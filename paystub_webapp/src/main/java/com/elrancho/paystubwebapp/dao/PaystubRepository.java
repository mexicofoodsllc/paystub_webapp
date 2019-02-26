package com.elrancho.paystubwebapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elrancho.paystubwebapp.entity.Paystub;

public interface PaystubRepository extends JpaRepository<Paystub,Integer>{

}
