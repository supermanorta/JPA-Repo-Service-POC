package com.JPAExample.JPAExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPAExample.JPAExample.crud.Employee;

import com.JPAExample.JPAExample.dao.EmployeeRespository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeRespository empRepo;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRespository theEmpRepo) {
		this.empRepo =theEmpRepo;
	}
	
	
	@Override
	public List<Employee> findAll() {
				
		return this.empRepo.findAll();
	}

	@Override
	public Employee findById(int Id) {
		// TODO Auto-generated method stub
		Optional<Employee> result =  empRepo.findById(Id);
		Employee theEmp = null;
		if( result.isPresent() ) {
			theEmp = result.get();
		}else {
			throw new RuntimeException( "Did not find Employee Id - "+ Id );
		}
		return theEmp;
	}

	@Override
	public void save(Employee emp) {
		
		empRepo.save(emp);
	}

	@Override
	public void deleteById(int Id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(Id);
	}

}
