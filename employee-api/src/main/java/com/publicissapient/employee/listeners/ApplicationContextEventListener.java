package com.publicissapient.employee.listeners;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class ApplicationContextEventListener {

	/*
	 * This gets called when application context is initialized or refreshed
	 * Here ContextStartedEvent/ContextStoppedEvent will work only when
	 * start() or stop() is called explicitly else won't work
	 * @Async is used to enable async processing and @EnableAsync is required
	 * to enable this.
	 * TODO add custom event publisher
	 */
	@Async
	@EventListener
	public void handleContextStart(ContextRefreshedEvent refreshEvent) {
        System.out.println("##Application has started successfully.");
    }
	
}
