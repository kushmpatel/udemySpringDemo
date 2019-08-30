package com.luv2code.springboot.cruddemo.rest;

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

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService theEmployeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.theEmployeeService = employeeService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return theEmployeeService.findAll();
	}
	
	// Get employee by employee id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return theEmployeeService.findById(employeeId);
	}
	
	//Add new Employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		theEmployeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		 theEmployeeService.save(theEmployee);
		 return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public int deleteEmployee(@PathVariable int employeeId) {
		 theEmployeeService.deleteById(employeeId);
		 return employeeId;
	}
	
}
