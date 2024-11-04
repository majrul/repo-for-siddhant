package com.seclore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping(path = "/update-emp")
	public String update(@RequestBody Employee emp) {
		employeeRepository.save(emp);
		return "Employee Updated";
	}

	@GetMapping(path = "/get-emp", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Employee get(@RequestParam int empno) {
		return employeeRepository.findById(empno).get();
	}
	
	@RequestMapping("/get-all-emps")
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorObj> handle(NoSuchElementException e) {
		ErrorObj obj = new ErrorObj();
		obj.setErrorMessage("No such emp exists!");
		return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
	}
	
	public static class ErrorObj {
		private String errorMessage;
		
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
	}
}

/*@ControllerAdvice
class MyExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorObj> handle(NoSuchElementException e) {
		ErrorObj obj = new ErrorObj();
		obj.setErrorMessage("No such emp exists!");
		return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
	}
}*/