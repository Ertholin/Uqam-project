package com.mindsoft.immobilierproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mindsoft.immobilierproject.model.Propriete;
import com.mindsoft.immobilierproject.repository.ProprieteRepository;
import com.mindsoft.immobilierproject.service.ProprieteServiceImpl;

@Controller
public class ProprieteController {

    @Autowired private ProprieteServiceImpl proprieteService;
    
    @Autowired private ProprieteRepository proprieteRepository;

    @RequestMapping(value = "/ajouterPropriete", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("prop", new Propriete());
        return "ajouterPropriete";
    }

    @RequestMapping(value = "/ajouterPropriete", method = RequestMethod.POST)
    public String enregistrerPropriete(@RequestParam("file") MultipartFile file,
                                       @RequestParam("type") String typePropriete,
                                       @RequestParam("prix") Double prix,
                                       @RequestParam("description") String description,
                                       @RequestParam("statut") String statut,
                                       @RequestParam("localisation") String localisation) {
        proprieteService.enregistrerPropriete(file, typePropriete, prix, description, statut, localisation);
        return "redirect:/mesProprietes";
    }
    
    @RequestMapping(value = "/proprietes", method = RequestMethod.GET)
    public String listPropriete(Model model) {
        List<Propriete> listProprietes = proprieteService.findAll();
        model.addAttribute("proprietes", listProprietes);
        
        return "welcome";
    }
    
    @GetMapping("/deleteProp/{id}")
    public String deletePropriete(@PathVariable("id") Long id) {
    	proprieteRepository.deleteById(id);
    	return "redirect:/proprietaire";
    }
    
    @RequestMapping("proprietes/findById")
	@ResponseBody
	public Optional<Propriete> findById(Long id) {
		return proprieteService.findById(id);
	}
    
    @RequestMapping(value="/proprietes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Propriete propriete) {
    	proprieteRepository.save(propriete);
		return "redirect:/proprietaire";
	}
    
	/*
	 * @PostMapping("/changeType") public String changeTypeProp(@RequestParam("id")
	 * Long id,
	 * 
	 * @RequestParam("newTypeProp") String typePropriete) { Propriete prop = new
	 * Propriete(); prop = proprieteRepository.findById(id).get();
	 * prop.setTypePropriete(typePropriete); proprieteRepository.save(prop); return
	 * "redirect:/proprietaire"; }
	 */
    
    
}
