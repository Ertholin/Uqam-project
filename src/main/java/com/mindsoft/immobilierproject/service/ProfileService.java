package com.mindsoft.immobilierproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mindsoft.immobilierproject.model.Profile;

public interface ProfileService {
	Profile addProfile(Profile profile);
    List<Profile> findByProprieteaire();
    List<Profile> findAll();
	public void save(Profile profile);
	public Optional<Profile> findById(Long id);
	
	
}
