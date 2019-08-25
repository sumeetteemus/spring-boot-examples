package com.publicissapient.employee.controller;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import com.publicissapient.employee.model.Employee;
import com.publicissapient.employee.model.resource.EmployeeResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public interface IEmployeeController {

	@ApiOperation(value = "View a list of available employees", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<Resources<EmployeeResource>> getAllEmployees();

	@ApiOperation(value = "Get an employee by Id")
	public ResponseEntity<Resource<EmployeeResource>> getEmployeeById(
			@ApiParam(value = "Employee object store in database table", required = true) 
			long id);

	@ApiOperation(value = "Add an employee")
	public ResponseEntity<Resource<EmployeeResource>> create(
			@ApiParam(value = "Employee object store in database table", required = true) 
			Employee employee);

}
