package com.cas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cas.entity.Employee;
import com.cas.service.EmployeeService;

@RestController("/cas")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping("/createEmployee")
	public void createEmployee(@RequestBody Employee newEmployee) {
		employeeService.createEmployee(newEmployee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
	}

	@PutMapping("/updateEmployee/{id}")
	public void updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable("id") Integer id) {
		employeeService.updateEmployee(updatedEmployee, id);
	}

}
