package com.mindsoft.immobilierproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.model.Propriete;

public interface ProprieteService {
    void enregistrerPropriete(MultipartFile file, String typePropriete, Double prix, String Description, String statut, String localisation);
    List<Propriete> findByProprieteaire();
    List<Propriete> findAll();
	public void save(Propriete propriete);
	//public Optional<Propriete> findById(Long id);
	public Optional<Propriete> findById(Long id);
	// Proprietaire findByProprietaire();
	
}
