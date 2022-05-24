package com.nnk.springboot.controllers;

import com.nnk.springboot.repositories.dto.CurvePointDTO;
import com.nnk.springboot.services.CurvePointService;

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
 * Curve Controller class which call Services crud methods
 * @author Silvio
 *
 */

@Controller
public class CurveController {
	
	static final Logger logger = LogManager.getLogger();

	@Autowired
	CurvePointService curvePointService;

    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
    	logger.info("Access to Curve list");
        model.addAttribute("curve", curvePointService.readAll() );
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePointDTO curvePointDTO) {
    	logger.info("Access to new Curve form");
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePointDTO curvePointDTO, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list
    	if (result.hasErrors()) {
    		logger.warn("Validation Error");
            return "curvePoint/add";
        }
    	curvePointService.create(curvePointDTO);
    	logger.info("New Curve added. ID : " + curvePointDTO.getId());
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get CurvePoint by Id and to model then show to the form
    	logger.info("Access to Curve update form");
    	model.addAttribute("curvePointDTO", curvePointService.read(id).get());
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @ModelAttribute @Valid CurvePointDTO curvePointDTO,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list
    	if (result.hasErrors()) {
    		logger.warn("Update Error");
            return "curvePoint/add";
        }
    	curvePointService.update(id, curvePointDTO);
    	logger.info("ID " + id + " Curve updated");
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list
    	logger.info("ID " + id + " Curve deleted");
    	curvePointService.delete(id);
        return "redirect:/curvePoint/list";
    }
}
