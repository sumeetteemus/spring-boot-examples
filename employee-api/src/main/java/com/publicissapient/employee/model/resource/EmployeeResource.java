package com.publicissapient.employee.model.resource;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.publicissapient.employee.controller.EmployeeController;
import com.publicissapient.employee.model.Employee;

import lombok.Getter;

@Getter
public class EmployeeResource extends ResourceSupport {

	private Employee employee;

	public EmployeeResource(final Employee employee) {
		this.employee = employee;
		this.add(ControllerLinkBuilder
				.linkTo(EmployeeController.class)
				.slash(employee.getId())
				.withSelfRel());
	}

}
