package com.elrancho.paystubwebapp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.elrancho.paystubwebapp.entity.Dba;

public interface DbaRepository extends JpaRepository<Dba,Integer>{
	
}
