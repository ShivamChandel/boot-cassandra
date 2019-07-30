package com.cas.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import com.cas.entity.Employee;

public interface EmployeeRepository extends CassandraRepository<Employee, Integer> {

}
