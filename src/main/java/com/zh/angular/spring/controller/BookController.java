package com.zh.angular.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	@RequestMapping(value = "adminBook**", method = RequestMethod.GET)
	public ModelAndView bookAdminPage() { 
		ModelAndView model = new ModelAndView();
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("book"); 
		return model; 
	}
 
	@RequestMapping(value = "dbaBook**", method = RequestMethod.GET)
	public ModelAndView bookDbaPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("book"); 
		return model; 
	}
}
