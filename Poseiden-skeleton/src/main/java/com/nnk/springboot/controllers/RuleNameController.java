package com.nnk.springboot.controllers;

import com.nnk.springboot.repositories.dto.RuleNameDTO;
import com.nnk.springboot.services.RuleNameService;

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
 * RuleName Controller class which call Services crud methods
 * @author Silvio
 *
 */

@Controller
public class RuleNameController {
	
	static final Logger logger = LogManager.getLogger();

	@Autowired
	RuleNameService ruleNameService;

    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
        // TODO: find all RuleName, add to model
    	logger.info("access to RuleName List");
    	model.addAttribute("ruleName", ruleNameService.readAll());
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleNameDTO RuleNameDTO) {
    	logger.info("access to new RuleName form");
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleNameDTO ruleNameDTO, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list
    	if (result.hasErrors()) {
    		logger.warn("validation error");
            return "/ruleName/add";
        }
    	ruleNameService.create(ruleNameDTO);
    	logger.info("new RuleName added. ID : " + ruleNameDTO.getId());
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form
    	logger.info("access to RuleName update form");
    	model.addAttribute("ruleNameDTO", ruleNameService.read(id).get());
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id,@ModelAttribute @Valid RuleNameDTO ruleNameDTO,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list
    	logger.info("ID : " + id + "RuleName updated");
    	if (result.hasErrors()) {
    		logger.warn("update error");
            return "/ruleName/update";
        }
    	ruleNameService.update(id, ruleNameDTO);
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list
    	logger.info("ID : " + id + "RuleName deleted");
    	ruleNameService.delete(id);
        return "redirect:/ruleName/list";
    }
}
