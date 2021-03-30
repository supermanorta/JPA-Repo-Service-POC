package com.JPAExample.JPAExample.service;

import java.util.List;

import com.JPAExample.JPAExample.crud.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(int Id);
	void save(Employee emp);
	void deleteById(int Id);
}
