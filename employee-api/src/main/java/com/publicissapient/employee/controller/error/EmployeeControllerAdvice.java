package com.publicissapient.employee.controller.error;

import java.util.Optional;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publicissapient.employee.exception.EmployeeNotFoundException;

@ControllerAdvice 
@RequestMapping(produces = "application/vnd.error+json") 
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeNotFoundException.class) 
	public ResponseEntity<VndErrors> notFoundException(final Exception ex) {
		String logref = logError(ex);
		return error(ex, 
				HttpStatus.NOT_FOUND, 
				logref);
	}

	@ExceptionHandler(IllegalArgumentException.class) 
	public ResponseEntity<VndErrors> assertionException(final Exception ex) {

		String logref = logError(ex);
		return error(ex, 
				HttpStatus.BAD_REQUEST, 
				logref);
	}

	private ResponseEntity<VndErrors> error(
			final Exception exception, 
			final HttpStatus httpStatus,
			final String logRef) {

		final String message = Optional.of(exception.getLocalizedMessage())
				.orElse(exception.getClass()
						.getSimpleName());

		return new ResponseEntity<VndErrors>(
				new VndErrors(logRef, message), 
				httpStatus);

	}

	private String logError(Exception ex) {
		return ex.getMessage();
	}
}
