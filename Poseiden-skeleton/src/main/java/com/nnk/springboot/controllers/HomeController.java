package com.nnk.springboot.controllers;

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

	@GetMapping("/")
	public String home(Model model)
	{
		return "home";
	}

	@GetMapping("/admin/home")
	public String adminHome(Model model)
	{
		return "redirect:/bidList/list";
	}

}
