package com.cas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cas.entity.Employee;
import com.cas.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void deleteEmployee(Integer empId) {
		// we can use try-catch here and return success message when deleted
		employeeRepository.deleteById(empId);

	}

	public void createEmployee(Employee employee) {
		employeeRepository.save(
				new Employee(employee.getEmpId(), employee.getEmpName(), employee.getEmpUnit(), employee.getSalary()));
	}

	public void updateEmployee(Employee employee, Integer empId) {
		Optional<Employee> temp = employeeRepository.findById(empId);
		if (temp.isPresent()) {
			Employee updateEmp = temp.get();
			updateEmp.setEmpName(employee.getEmpName());
			updateEmp.setEmpUnit(employee.getEmpUnit());
			updateEmp.setSalary(employee.getSalary());
			employeeRepository.save(updateEmp);

		}
	}

}
