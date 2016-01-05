package com.trello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Test{
		
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView postRegistrationForm(Model model){
		return new ModelAndView("test");
	}

}
