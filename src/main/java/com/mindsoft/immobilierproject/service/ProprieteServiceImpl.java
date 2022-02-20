package com.mindsoft.immobilierproject.service;

import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.model.Propriete;
import com.mindsoft.immobilierproject.model.User;
import com.mindsoft.immobilierproject.repository.ProprieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProprieteServiceImpl implements ProprieteService {

    @Autowired
    private ProprieteRepository proprieteRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProprietaireService proprietaireService;

    private Proprietaire proprietaire;

    public void enregistrerPropriete(MultipartFile file, String typePropriete, Double prix, String Description, String statut,
                                     String localisation) {
        Propriete p = new Propriete();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains(".."))
            System.out.println("Type de fichier invalide");
        
        proprietaire = proprietaireService.findByUser(userService.findByUsername(UserDetailsServiceImpl.pseudo));
        p.setPhoto(fileName);
        p.setTypePropriete(typePropriete);
        p.setPrix(prix);
        p.setDescription(Description);
        p.setStatut(statut);
        p.setLocalisation(localisation);
        p.setDate(new Date());
        p.setProprietaire(proprietaire);

        proprieteRepository.save(p);
    }

    @Override
    public List<Propriete> findByProprieteaire() {
        proprietaire = proprietaireService.findByUser(userService.findByUsername(UserDetailsServiceImpl.pseudo));
        return proprieteRepository.findByProprietaire(proprietaire);
    }

	@Override
	public List<Propriete> findAll() {
		return proprieteRepository.findAll();
	}

	@Override
	public void save(Propriete propriete) {
		proprieteRepository.save(propriete);
		
	}

	@Override
	public Optional<Propriete> findById(Long id) {
		return proprieteRepository.findById(id);
	}

//	@Override
//	public Proprietaire findByProprietaire() {
//		proprietaire = proprietaireService.findByUser(userService.findByUsername(UserDetailsServiceImpl.pseudo));
//		return (Proprietaire) proprieteRepository.findByProprietaire(proprietaire);
//	}

	/*
	 * @Override public Optional<Propriete> findById(Long id) { return
	 * proprieteRepository.findById(id); }
	 */

	/*
	 * @Override public void delete(Long id) { proprieteRepository.deleteById(id); }
	 */
	
	



}
