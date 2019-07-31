/**
 * Author: Shivam_Chandel
 * Comments: Database/Repo interaction interface
 */

package com.cas.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.cas.entity.Employee;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, Integer> {

}
