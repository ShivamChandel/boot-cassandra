/**
 * Author : Shivam_Chandel
 * Comments: Class serving all incoming requests
 */

package com.cas.controller;

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
import com.cas.entity.Employee;
import com.cas.service.EmployeeService;

@RestController
@RequestMapping(value = "/cas")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// Another way to map the rest urls
	// @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	@GetMapping(value = "/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// Hit from rest client POST request, with request body as
	// {"empId":"2","empName":"shivam","empUnit":"ENGSP","salary":"32000"}
	@PostMapping(value = "/createEmployee", consumes = "application/json", produces = "application/json")
	public void createEmployee(@RequestBody Employee newEmployee) {
		employeeService.createEmployee(newEmployee);
	}

	@DeleteMapping(path = "/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
	}

	@PutMapping(value = "/updateEmployee/{id}")
	public void updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable Integer id) {
		employeeService.updateEmployee(updatedEmployee, id);
	}

}
