package com.JPAExample.JPAExample.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPAExample.JPAExample.crud.Employee;

import com.JPAExample.JPAExample.service.EmployeeServiceImp;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeServiceImp empImp;
	// dirty injection, will need a service layer later
	@Autowired
	public EmployeeRestController(EmployeeServiceImp dao) {
		this.empImp =dao;
	}
	//expose /employee to return all the list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return empImp.findAll();
	}
	@GetMapping("/employees/{employeeId}")
	public Employee createEmployee(@PathVariable int employeeId) {
		Employee emp = empImp.findById(employeeId);
		if(emp ==null) {
			throw new RuntimeException("Employee id not found- "+ employeeId);
		}
		return emp;
	}
	@PostMapping("/employees")
	public Employee addEmployee( @RequestBody Employee theEmp) {
		theEmp.setId(0);
		this.empImp.save(theEmp);
		return theEmp;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee( @RequestBody Employee theEmp ) {
		this.empImp.save(theEmp);
		return theEmp;
	}
	
	@DeleteMapping( "/employees/{employeeId}" )
	public String deleteEmployee(@PathVariable int employeeId){
		
		if(this.empImp.findById(employeeId) == null) {
			throw new RuntimeException("Employee id not found "+ employeeId);
		}
		this.empImp.deleteById(employeeId);
		return "Deleted employee id -" + employeeId;
	}
}
