package com.example.demo.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
public class Person {

	private String name;

	@Value("${spring.application.name}")
	private String appName;

	public Person(String name) {
		this.name = name;
		System.out.println("Person " + this.name + " is instantiated");
		// publisher.publishEvent(new PersonCreatedEvent(this));
	}

	@PostConstruct
	public void init() {
		System.out.println(this.appName + "'s init called");
	}

	@PreDestroy
	public void destroy() {
		System.out.println(this.appName + "'s destroy called");
	}

}
