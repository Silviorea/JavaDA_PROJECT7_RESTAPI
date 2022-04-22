package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.repositories.dto.UserDTO;
import com.nnk.springboot.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    

    @RequestMapping("/user/list")
    public String home(Model model)
    {
        model.addAttribute("user", userService.readAll());
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User user) {
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid UserDTO userDTO, BindingResult result, Model model) {
      
            model.addAttribute("user", userDTO);
            userService.create(userDTO);
            
            return "redirect:/user/list";
       
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        
        model.addAttribute("user", userService.read(id).get());
        return "user/update";
    }

    ////////////////////////////////////
    ///////  UPDATE A FAIRE ////////////
    ////////////////////////////////////
    
    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model,
                             String username, String password, String fullname, String role) {
        if (result.hasErrors()) {
            return "user/update";
        }

        model.addAttribute("user", userService.read(id).get());
        
        userService.update(id, username, fullname, password, role);
       
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        userService.delete(id);
        return "redirect:/user/list";
    }
}
