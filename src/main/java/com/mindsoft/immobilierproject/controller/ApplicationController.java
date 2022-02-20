package com.mindsoft.immobilierproject.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.model.Propriete;
import com.mindsoft.immobilierproject.model.Role;
import com.mindsoft.immobilierproject.service.ProprietaireService;
import com.mindsoft.immobilierproject.service.ProprieteService;
import com.mindsoft.immobilierproject.service.SecurityService;
import com.mindsoft.immobilierproject.service.UserService;

@Controller
public class ApplicationController {
	
	@Autowired 
	private ProprieteService proprieteService; 
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private ProprietaireService proprietaireService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
	public static String username;
	
// UserController
	  @GetMapping("/login")
	  public String login(Model model, String error, String logout) {
	
	      if (securityService.isAuthenticated()) {
	          return "redirect:/index";
	      }
	
	      if (error != null)  model.addAttribute("error", "Your username and password is invalid.");
	         
	      if (logout != null)  model.addAttribute("message", "You have been logged out successfully.");
	         
	      return "login";
	  }
	
// Accueils Controller
	@GetMapping({"/","/index"})
	public String homeGnle() {
		return "homeGnle";
	}
	
	@GetMapping("/about")
	public String aboutGnle() {
		return "aboutGnle";
	}
	
	@GetMapping("/services")
	public String servicesGnles() {
		return "servicesGnles";
	}
	
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String listPropriete(Model model) {
        List<Propriete> listProprietes = proprieteService.findAll();
        model.addAttribute("proprietes", listProprietes);
        
        return "home";
    }
    
    
// Registration Controller
  @GetMapping("/registration")
  public String registration(Model model) {

//      if (securityService.isAuthenticated()) {
//          return "redirect:/login";
//      }

      model.addAttribute("userForm", new Proprietaire());
      
      List<Role> listRoles = userService.getRoles();
      model.addAttribute("listRoles", listRoles);

      return "register";
  }

  @PostMapping("/registration")
  public String registration(@ModelAttribute("userForm") Proprietaire proprietaire, BindingResult bindingResult) throws IOException {

      userValidator.validate(proprietaire, bindingResult);

      if (bindingResult.hasErrors()) {
          return "register";
      }

      userService.save(proprietaire.getUser());
      //securityService.autoLogin(proprietaire.getUser().getUsername(), proprietaire.getUser().getPasswordConfirm());
      proprietaireService.create(proprietaire);
      

      return "redirect:/registration?success";
  }
  
  @GetMapping("/403")
  public String error403() {
      return "403";
  }
  
//  @GetMapping("/proprietaire1")
//  public String prop() {
//      return "proprietaire";
//  }
  
//Proprietaire Controller
	  @RequestMapping(value = "/proprietaire", method = RequestMethod.GET)
		public String listProprietes(Model model) {
		     List<Propriete> proprietes = proprieteService.findByProprieteaire();
		     model.addAttribute("proprietes", proprietes);
		
		     return "proprietaire_dashboard";
	  }
  
	@RequestMapping(value = "/infosProprietaires", method = RequestMethod.GET)
	public String infosProprietaires(Model model) {
		List<Propriete> proprietes = proprieteService.findByProprieteaire();
	    model.addAttribute("proprietes", proprietes);
	    
		return "infosProprietaire";
	}
	
	  @RequestMapping(value = "/mesProprietes", method = RequestMethod.GET)
		public String indexDashboard(Model model) {
		     List<Propriete> proprietes = proprieteService.findByProprieteaire();
		     model.addAttribute("proprietes", proprietes);
		
		     return "proprietaire";
	  }


}
