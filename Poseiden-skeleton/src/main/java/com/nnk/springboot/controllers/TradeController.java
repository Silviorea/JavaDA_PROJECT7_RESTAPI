package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.dto.TradeDTO;
import com.nnk.springboot.services.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class TradeController {


	@Autowired
	TradeService tradeService;

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        model.addAttribute("trade", tradeService.readAll());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid TradeDTO trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
       
    	if (result.hasErrors()) {
            return "/trade/add";
        }
    	
    	model.addAttribute("trade", trade);
    	tradeService.create(trade);
    	return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
    	
    	model.addAttribute("trade", tradeService.read(id).get());
    	
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model,
                             String account, String type, Double buyQuantity) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
    	
    	if (result.hasErrors()) {
            return "/trade/update";
        }
    	
    	model.addAttribute("trade", tradeService.read(id).get());
    	tradeService.update(id, account, type, buyQuantity);
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
    	tradeService.delete(id);
        return "redirect:/trade/list";
    }
}
