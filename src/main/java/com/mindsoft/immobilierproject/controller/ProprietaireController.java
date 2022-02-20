package com.mindsoft.immobilierproject.controller;

import com.mindsoft.immobilierproject.model.Propriete;
import com.mindsoft.immobilierproject.repository.ProprieteRepository;
import com.mindsoft.immobilierproject.service.ProprieteService;
import com.mindsoft.immobilierproject.service.ProprieteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@Controller
public class ProprietaireController {

//    @Autowired
//    private ProprieteService proprieteService;
//    
//    @Autowired private ProprieteRepository proprieteRepository;
//
//
//    @RequestMapping(value = "/proprietaire", method = RequestMethod.GET)
//    public String listPropriete(Model model) {
//        List<Propriete> proprietes = proprieteService.findByProprieteaire();
//        model.addAttribute("proprietes", proprietes);
//
//        return "proprietaire";
//    }
//    
//    @RequestMapping(value = "/mesInfos", method = RequestMethod.GET)
//    public String mesInfos(Model model) {
//    	List<Propriete> proprietes = proprieteService.findByProprieteaire();
//        model.addAttribute("proprietes", proprietes);
//        
//    	return "infosProprietaire";
//    }

}