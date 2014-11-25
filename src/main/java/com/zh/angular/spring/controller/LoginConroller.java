package com.zh.angular.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginConroller {
 
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		return model; 
	}
 
	@RequestMapping(value = {"/login**" }, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model; 
	}
 
}