package com.mindsoft.immobilierproject.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindsoft.immobilierproject.model.Profile;
import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProprietaireService proprietaireService;

    private Proprietaire proprietaire;

    public Profile addProfile(Profile profile) {
        proprietaire = proprietaireService.findByUser(userService.findByUsername(UserDetailsServiceImpl.pseudo));
        profile.setProprietaire(proprietaire);
        profile.setProfileDate(new Date());
        return profileRepository.save(profile);
    }
    
    @Override
    public List<Profile> findByProprieteaire() {
        proprietaire = proprietaireService.findByUser(userService.findByUsername(UserDetailsServiceImpl.pseudo));
        return profileRepository.findByProprietaire(proprietaire);
    }

	@Override
	public List<Profile> findAll() {
		return profileRepository.findAll();
	}

	@Override
	public void save(Profile profile) {
		profileRepository.save(profile);		
	}

	@Override
	public Optional<Profile> findById(Long id) {
		return profileRepository.findById(id);
	}

}
