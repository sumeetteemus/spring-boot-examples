package com.publicissapient.employee.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	/**
	 * TODO
	 */
	private static final long serialVersionUID = -4560670902619944063L;
	
	public EmployeeNotFoundException(long id) {
		this("Employee id not found: " + id);
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public String getLocalizedMessage() {
		return "Employee not found. Provide a valid employee.";
	}

}
