package com.seclore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seclore.entity.Employee;
import com.seclore.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	/*@RequestMapping("/add-emp")
	public String add(@RequestParam String name, 
					  @RequestParam String dateOfJoining, 
					  @RequestParam double salary, 
					  Model model) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDateOfJoining(LocalDate.parse(dateOfJoining));
		emp.setSalary(salary);
		
		employeeRepository.save(emp);
		
		model.addAttribute("message", "Employee added successfully!");
		return "addEmp.jsp";
	}*/
	
	// Spring can automatically copy form data in an object for us
	@RequestMapping("/add-emp")
	public String add(Employee emp, Model model) {
		employeeRepository.save(emp);
		model.addAttribute("message", "Employee added successfully!");
		return "addEmp.jsp";
	}
}
