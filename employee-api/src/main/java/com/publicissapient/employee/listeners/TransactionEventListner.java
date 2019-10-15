package com.publicissapient.employee.listeners;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

//TODO
@Component
public class TransactionEventListner {

	//TODO  Not working
	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	public void handleCustom(CustomSpringEvent event) {
	    System.out.println("Handling event inside a transaction BEFORE COMMIT.");
	}
}
