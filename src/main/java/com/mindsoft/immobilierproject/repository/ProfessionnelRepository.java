package com.mindsoft.immobilierproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindsoft.immobilierproject.model.Professionnel;
import com.mindsoft.immobilierproject.model.User;

public interface ProfessionnelRepository extends JpaRepository<Professionnel, Long>{
	Professionnel findByUser(User user);
}
