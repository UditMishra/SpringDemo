package com.example.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class Test {

	private String name;

	@Autowired
	MessageSource source;

	@Override
	public String toString() {
		System.out.println(this.source.getMessage("mymessage", new Object[] { this.name }, "Hello World !", null));
		return "test";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
