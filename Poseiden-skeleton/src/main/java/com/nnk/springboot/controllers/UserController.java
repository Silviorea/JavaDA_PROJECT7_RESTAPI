package com.nnk.springboot.controllers;

import com.nnk.springboot.repositories.dto.UserDTO;
import com.nnk.springboot.services.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * User Controller class which call Services crud methods
 * @author Silvio
 *
 */

@Controller
public class UserController
{
	static final Logger logger = LogManager.getLogger();
	
	@Autowired
	private UserService userService;

	@RequestMapping("/user/list")
	public String home(Model model)
	{
		logger.info("access to user list");
		model.addAttribute("user", userService.readAll());
		return "user/list";
	}

	@GetMapping("/user/add")
	public String addUser(UserDTO userDTO)
	{
		logger.info("access to new User form");
		return "user/add";
	}

	@PostMapping("/user/validate")
	public String validate(@ModelAttribute @Valid UserDTO userDTO, BindingResult result, Model model)
	{
		
		if (result.hasErrors())
		{
			logger.warn("validation error");
			return "user/add";
		}
		userService.create(userDTO);
		
		logger.info("New " + userDTO.getRole() + " just created. Welcome to " + userDTO.getUsername());
		
		return "redirect:/user/list";
	}

	@GetMapping("/user/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model)
	{
		logger.info("Access to User update form");
		model.addAttribute("userDTO", userService.read(id).get());
		return "user/update";
	}

	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") Integer id, @ModelAttribute @Valid UserDTO userDTO,
			BindingResult result, Model model)
	{
		
		if (result.hasErrors())
		{
			logger.warn("update error");
			return "user/update";
		}
		userService.update(id, userDTO);
		logger.info(userDTO.getRole() + " " + userDTO.getUsername() + " updated");
		return "redirect:/user/list";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model)
	{
		logger.info("ID : " + id + " User Deleted");
		userService.delete(id);
		return "redirect:/user/list";
	}
}
