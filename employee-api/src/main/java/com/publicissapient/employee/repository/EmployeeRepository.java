package com.publicissapient.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.publicissapient.employee.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
		
}
