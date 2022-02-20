package com.mindsoft.immobilierproject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.model.Role;
import com.mindsoft.immobilierproject.service.ProprietaireService;
import com.mindsoft.immobilierproject.service.SecurityService;
import com.mindsoft.immobilierproject.service.UserService;

//@Controller
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private ProprietaireService proprietaireService;
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserValidator userValidator;
//
//    @GetMapping("/registration")
//    public String registration(Model model) {
//
//        if (securityService.isAuthenticated()) {
//            return "redirect:/login";
//        }
//
//        model.addAttribute("userForm", new Proprietaire());
//        
//        List<Role> listRoles = userService.getRoles();
//        model.addAttribute("listRoles", listRoles);
//
//        return "register";
//    }
//
//    @PostMapping("/registration")
//    public String registration(@ModelAttribute("userForm") Proprietaire proprietaire, BindingResult bindingResult) throws IOException {
//
//        userValidator.validate(proprietaire, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "register";
//        }
//
//        userService.save(proprietaire.getUser());
//        securityService.autoLogin(proprietaire.getUser().getUsername(), proprietaire.getUser().getPasswordConfirm());
//        proprietaireService.create(proprietaire);
//        
//
//        return "redirect:/login";
//    }
//    
//    @GetMapping("/")
//    public String log() {
//    	return "redirect:/index";
//    }
//
//    @GetMapping("/login")
//    public String login(Model model, String error, String logout) {
//
//        if (securityService.isAuthenticated()) {
//            return "redirect:/index";
//        }
//
//        if (error != null)  model.addAttribute("error", "Your username and password is invalid.");
//           
//        if (logout != null)  model.addAttribute("message", "You have been logged out successfully.");
//           
//        return "login";
//    }

//    @GetMapping("/") 
//	public String welcome(Model model) { 
//	  return "proprietaire"; 
//	}
	 
}
