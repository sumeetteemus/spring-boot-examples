package com.publicissapient.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicissapient.employee.exception.EmployeeNotFoundException;
import com.publicissapient.employee.model.Employee;
import com.publicissapient.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		List<Employee> employeeList = new ArrayList<>();
		employeeRepository.findAll().forEach(employeeList::add);
		return employeeList;
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployeeById(long id) throws EmployeeNotFoundException {

		return employeeRepository
				.findById(id)	
				.orElseThrow(
						() -> new EmployeeNotFoundException(id));
	}
}
