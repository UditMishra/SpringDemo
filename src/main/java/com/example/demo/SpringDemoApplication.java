package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.example.demo.beans.Person;
import com.example.demo.beans.Test;

@SpringBootApplication
public class SpringDemoApplication implements ApplicationContextAware {

	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	private void testBeans(String beanName) {

		Person pa = context.getBean(beanName, Person.class);
		Person pb = context.getBean(beanName, Person.class);

		System.out.println(pa.hashCode() == pb.hashCode());
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		testBeans("p1");
		testBeans("p2");
		Test t = context.getBean("test", Test.class);
		t.setName("Udit");
		System.out.println(t);
	}

}
