package com.seclore.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Map<String, Object> model) {
		model.put("message", "Welcome to Spring MVC");
		return "hello.jsp";
	}

	@GetMapping("/hello2")
	public String hello2(ModelMap model) {
		model.put("message", "Welcome to Spring MVC");
		return "hello.jsp";
	}

	@GetMapping("/hello3")
	public String hello3(Model model) {
		model.addAttribute("message", "Welcome to Spring MVC");
		return "hello.jsp";
	}

	@GetMapping("/hello4")
	public ModelAndView hello4() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Welcome to Spring MVC");
		mav.setViewName("hello.jsp");
		return mav;
	}
}

