package com.nnk.springboot.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home Controller class wich display the home page
 * 
 * @author Silvio
 *
 */

@Controller
public class HomeController
{
	static final Logger logger = LogManager.getLogger();
	
	@GetMapping("/")
	public String home(Model model)
	{
		logger.info("Access to Home Page");
		return "home";
	}

	@GetMapping("/admin/home")
	public String adminHome(Model model)
	{
		logger.info("Access to admin Home Page");
		return "redirect:/bidList/list";
	}

}
