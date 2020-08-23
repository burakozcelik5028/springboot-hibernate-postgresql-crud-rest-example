package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	// get employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return this.repo.findAll();
	}
	
	// get employees by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empId) throws ResourceNotFoundException{
		Employee employee = repo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee for this id not found :: "
				+ empId));
		return ResponseEntity.ok().body(employee);
	}
	
	// save employee
	@PostMapping("/employees")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		return repo.save(employee);
	}
	
	// update employee
	// delete employee
}
