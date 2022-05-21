package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.dto.RatingDTO;
import com.nnk.springboot.services.RatingService;

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
 * Rating Controller class which call Services crud methods
 * @author Silvio
 *
 */

@Controller
public class RatingController {

	@Autowired
	RatingService ratingService;

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        // TODO: find all Rating, add to model
    	model.addAttribute("rating", ratingService.readAll());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(RatingDTO ratingDTO) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid RatingDTO ratingDTO, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
    	
    	if (result.hasErrors()) {
            return "/rating/add";
        }
    	
    	ratingService.create(ratingDTO);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
    	
    	model.addAttribute("ratingDTO", ratingService.read(id).get());
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id,@ModelAttribute @Valid RatingDTO ratingDTO,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
    	
    	if (result.hasErrors()) {
            return "/rating/update";
        }
    	
    	ratingService.update(id, ratingDTO);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
    	ratingService.delete(id);
        return "redirect:/rating/list";
    }
}
