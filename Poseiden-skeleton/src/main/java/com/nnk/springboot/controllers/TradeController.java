package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.dto.TradeDTO;
import com.nnk.springboot.services.TradeService;

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
 * Trade Controller class which call Services crud methods
 * @author Silvio
 *
 */

@Controller
public class TradeController {


	static final Logger logger = LogManager.getLogger();
	
	@Autowired
	TradeService tradeService;

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
    	logger.info("access to Trade list");
        model.addAttribute("trade", tradeService.readAll());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(TradeDTO tradeDTO) {
    	logger.info("access to new Trade form");
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid TradeDTO tradeDTO, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
    	
    	if (result.hasErrors()) {
    		logger.warn("validation error");
            return "/trade/add";
        }
    	logger.info("new Trade added. ID : " + tradeDTO.getTradeId());
    	tradeService.create(tradeDTO);
    	return "redirect:/trade/list";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
    	logger.info("access to Trade update form");
    	model.addAttribute("tradeDTO", tradeService.read(id).get());
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id,@ModelAttribute @Valid TradeDTO tradeDTO,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
    	logger.info("ID : " + id + " Trade Updated");
    	if (result.hasErrors()) {
    		logger.warn("update error");
            return "/trade/update";
        }
    	tradeService.update(id, tradeDTO);
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
    	logger.info("ID : " + id + " Trade deleted");
    	tradeService.delete(id);
        return "redirect:/trade/list";
    }
}
