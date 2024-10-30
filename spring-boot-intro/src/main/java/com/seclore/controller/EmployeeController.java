package com.seclore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seclore.entity.Employee;
import com.seclore.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping(path = "/add-emp")
	public String add(@RequestBody Employee emp) {
		employeeRepository.save(emp);
		return "Employee Added";
	}
	
	@GetMapping(path = "/get-emp", produces = MediaType.APPLICATION_XML_VALUE)
	public Employee get(@RequestParam int empno) {
		return employeeRepository.findById(empno).get();
	}
	
	@RequestMapping("/get-all-emps")
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
}