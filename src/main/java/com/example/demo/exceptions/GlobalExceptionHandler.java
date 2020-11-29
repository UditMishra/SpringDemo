package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public String getMessage(Throwable t) {
		return "Global Handler handled, msg : " + t.getMessage();
	}
}
