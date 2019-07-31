/**
 * Author: Shivam_Chandel
 * Comments: The entity/table class
 */

package com.cas.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private Integer empId;
	private String empName;
	private String empUnit;
	private double salary;

	public Employee() {

	}

	public Employee(Integer empId, String empName, String empUnit, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empUnit = empUnit;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpUnit() {
		return empUnit;
	}

	public void setEmpUnit(String empUnit) {
		this.empUnit = empUnit;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empUnit=" + empUnit + ", salary=" + salary
				+ "]";
	}

}
