package com.JPAExample.JPAExample.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPAExample.JPAExample.crud.Employee;


public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
//will give me all the basic calls to the 
}
