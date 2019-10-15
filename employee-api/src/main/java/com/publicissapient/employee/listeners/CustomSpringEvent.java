package com.publicissapient.employee.listeners;

import org.springframework.context.ApplicationEvent;

//TODO
public class CustomSpringEvent extends ApplicationEvent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5817655566380086643L;
	private String message;
 
    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}