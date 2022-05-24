package com.nnk.springboot.controllers;

import com.nnk.springboot.repositories.dto.BidListDTO;
import com.nnk.springboot.services.BidListService;

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
 * BidList Controller class which call Services crud methods
 * @author Silvio
 *
 */

@Controller
public class BidListController
{

	static final Logger logger = LogManager.getLogger();
	
	@Autowired
	BidListService bidListService;

	@RequestMapping("/bidList/list")
	public String home(Model model)
	{
		// TODO: call service find all bids to show to the view
		
		logger.info("BidList access to list");
		model.addAttribute("bidlist", bidListService.readAll());
		return "bidList/list";
	}

	@GetMapping("/bidList/add")
	public String addBidForm(BidListDTO bidListDTO)
	{
		logger.info("Access to new BidList form");
		return "bidList/add";
	}

	@PostMapping("/bidList/validate") 
	public String validate(@Valid BidListDTO bidListDTO, BindingResult result, Model model)
	{
		
		// TODO: check data valid and save to db, after saving return bid list

		if (result.hasErrors())
		{
			logger.warn("validation error");
			return "bidList/add";
		}
		bidListService.create(bidListDTO);
		logger.info("New BidList added. ID : " + bidListDTO.getBidListId());
		return "redirect:/bidList/list";
	}

	@PostMapping("/bidList/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @ModelAttribute @Valid BidListDTO bidListDTO, 
			BindingResult result, Model model)
	{
		// TODO: check required fields, if valid call service to update Bid and return
		
		
		
		if (result.hasErrors())
		{
			
			logger.warn("Update error");
			return "bidList/update";
		}

		bidListService.update(id, bidListDTO);
		
		logger.info("ID " + id + " BidList updated");
		return "redirect:/bidList/list";
	}

	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model)
	{
		// TODO: get Bid by Id and to model then show to the form
		logger.info("Access to BidList update form");
		model.addAttribute("bidListDTO", bidListService.read(id).get());

		return "bidList/update";
	}

	@GetMapping("/bidList/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model)
	{
		// TODO: Find Bid by Id and delete the bid, return to Bid list
		logger.info("ID " + id + " BidList deleted");
		bidListService.delete(id);

		return "redirect:/bidList/list";
	}
}
