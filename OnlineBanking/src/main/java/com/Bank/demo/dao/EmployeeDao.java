package com.Bank.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Bank.demo.model.Employee;

@Repository
@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Long> {
	
	public Employee findEmployeeByEmail(String email);
	
	@Query("select e.password from employee e where e.email= :email")
	public String getPasswordByEmail(@Param("email")String email);
	
	public Integer deleteByEmail(String email);

}
