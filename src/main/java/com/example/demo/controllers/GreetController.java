package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/greetings")
	public ModelAndView sayHello(@RequestParam(value = "name") String name) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("greeting" + (name.contains("U") ? "s" : ""));
		if (mv.getViewName().equals("greetings")) {
			throw new RuntimeException("Oops");
		}
		System.out.println(name.toCharArray()[10]);
		mv.addObject("msg", "to " + name + " from Greetings");
		return mv;
	}

	@ExceptionHandler({ ArrayIndexOutOfBoundsException.class })
	@ResponseBody
	public String handleException() {
		return "Caught an Array out of bounds !";
	}
}
