package com.mindsoft.immobilierproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindsoft.immobilierproject.model.Profile;
import com.mindsoft.immobilierproject.model.Propriete;
import com.mindsoft.immobilierproject.service.ProfessionnelService;


@Controller
public class ProfessionnelController {
	
	@Autowired ProfessionnelService professionnelService;
	
//	@GetMapping("/professionnels")
//	public String homeProfessionnel() {
//		return "homeProfessionnel";
//	}
	
	
	@RequestMapping(value = "/professionnel", method = RequestMethod.GET)
	public String professionnels(Model model) {
		
		return "/professionnel_dashboard";
	}
	
//	@RequestMapping(value = "/ajouterProfile", method = RequestMethod.GET)
//	public String addProfiles(Model model) {
//		
//		return "/ajouterProfile";
//	}
	
//	@RequestMapping(value = "/infosProfessionnel", method = RequestMethod.GET)
//	public String infosProfessionnels(Model model) {
		//List<Profile> profiles = professionnelService.findByProprieteaire();
	    //model.addAttribute("proprietes", profiles);
//	    
//		return "infosProfessionnel";
//	}
	
//	  @RequestMapping(value = "/mesProfiles", method = RequestMethod.GET)
//		public String indexDashboard(Model model) {
		     //List<Profile> profiles = proprieteService.findByProprieteaire();
		     //model.addAttribute("proprietes", profiles);
//		
//		     return "professionnel";
//	  }

}
