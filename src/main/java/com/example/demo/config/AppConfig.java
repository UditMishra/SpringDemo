package com.example.demo.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.example.demo.beans.Person;
import com.example.demo.beans.Test;
import com.example.demo.postprocessors.MyBeanFactoryPostProcessor;
import com.example.demo.postprocessors.MyBeanPostProcessor;

@Configuration
public class AppConfig {

	@Bean(value = "p1", initMethod = "init", destroyMethod = "destroy")
	@Scope("singleton")
	public Person getPerson1() {
		return new Person("p1");
	}

	@Bean(value = "p2", initMethod = "init", destroyMethod = "destroy")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Person getPerson2() {
		return new Person("p2");
	}

	@Bean
	public MyBeanPostProcessor getBeanPostProcessor() {
		return new MyBeanPostProcessor();
	}

	@Bean
	public static MyBeanFactoryPostProcessor getBeanFactoryPostProcessor() {
		return new MyBeanFactoryPostProcessor();
	}

	@Bean("source")
	public MessageSource getMessageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("mymessagesource");
		return source;
	}

	@Bean("test")
	public Test getTest() {
		return new Test();
	}
}
