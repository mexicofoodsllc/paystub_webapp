package com.elrancho.paystubwebapp.repository;

import com.elrancho.paystubwebapp.entity.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer>{

	List<Users> findByEmployeeId(int employeeId);
}
