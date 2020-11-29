package com.example.demo.events;

import org.springframework.context.ApplicationEvent;

public class PersonCreatedEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3983864431283153261L;

	public PersonCreatedEvent(Object source) {
		super(source);
	}

	@Override
	public String toString() {
		return "Person Created";
	}
}
