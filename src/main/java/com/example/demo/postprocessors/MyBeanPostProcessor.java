package com.example.demo.postprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.example.demo.beans.Person;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Person) {
			System.out.println("Before initializing bean : " + beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Person) {
			System.out.println("After initializing bean : " + beanName);
		}
		return bean;
	}
}
