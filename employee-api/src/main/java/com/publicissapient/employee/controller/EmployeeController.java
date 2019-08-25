package com.publicissapient.employee.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.publicissapient.employee.model.Employee;
import com.publicissapient.employee.model.resource.EmployeeResource;
import com.publicissapient.employee.service.EmployeeService;

@RestController
@RequestMapping(value="/employee", produces = "application/hal+json") 
public class EmployeeController implements IEmployeeController{

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all") 
	public ResponseEntity<Resources<EmployeeResource>> getAllEmployees() {

		final List<EmployeeResource> employeeResources = employeeService.getAll()
				.stream()
				.map(EmployeeResource::new)
				.collect(Collectors.toList());

		Resources<EmployeeResource> resourceWrapper = new Resources<>(employeeResources);
		resourceWrapper.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder
						.methodOn(getClass()).getAllEmployees())
				.withSelfRel());

		return new ResponseEntity<Resources<EmployeeResource>>(resourceWrapper, HttpStatus.OK);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Resource<EmployeeResource>> getEmployeeById(@PathVariable("employeeId") long id) {

		final EmployeeResource employeeResource = new EmployeeResource(employeeService.getEmployeeById(id));
		Resource<EmployeeResource> resourceWrapper = new Resource<>(employeeResource);
		return new ResponseEntity<Resource<EmployeeResource>>(
				resourceWrapper, 
				HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<Resource<EmployeeResource>> create(@RequestBody Employee employee) {

		final EmployeeResource employeeResource = new EmployeeResource(
				employeeService.createEmployee(employee));
		Resource<EmployeeResource> resourceWrapper = new Resource<>(employeeResource);
		return new ResponseEntity<Resource<EmployeeResource>>(
				resourceWrapper, 
				HttpStatus.CREATED);
	}

}
