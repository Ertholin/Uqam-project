package com.mindsoft.immobilierproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindsoft.immobilierproject.model.Profile;
import com.mindsoft.immobilierproject.model.Proprietaire;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

	List<Profile> findByProprietaire(Proprietaire proprietaire);
}
