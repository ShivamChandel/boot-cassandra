package com.cas.service;

import java.util.List;

import com.cas.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer empId);

	public void createEmployee(Employee employee);

	public void updateEmployee(Employee employee, Integer empId);

}
