package com.elrancho.paystubwebapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elrancho.paystubwebapp.entity.Employee;

/*
 * EmployeeRepository interface extends JpaRepository to manage entities for most common operations,
 *  such as saving an entity, updating it, deleting it, or finding it by id. 
 *  Programmer has to provide the entity type (Employee or user) and data type of primary key.
 *  EmployeeRepository I replaces the use of dao and daoimplementation class.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	List<Employee> findByEmployeeId(int employeeId);
	List<Employee> findByBirthDateAndSsn(LocalDate birthDate, String ssn);
}
