package com.Bank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.demo.dao.EmployeeDao;
import com.Bank.demo.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public void saveEmployee(Employee employee) {
		employeeDao.save(employee);
	}
	
	public void deleteClientByEmail(String email) {
		employeeDao.findEmployeeByEmail(email);
	}
	public List<Employee> getAllEmployees(){
		List<Employee> employees=(List<Employee>) employeeDao.findAll();
		return employees;
	}
	public Employee getEmployeeByMail(String email) {
		Employee employee = employeeDao.findEmployeeByEmail(email);
		return employee;
	}
	
	public String getEmployeePasswordByEmail(String email) {
		String encryptedPassword=employeeDao.getPasswordByEmail(email);
		return encryptedPassword;
	}

}
