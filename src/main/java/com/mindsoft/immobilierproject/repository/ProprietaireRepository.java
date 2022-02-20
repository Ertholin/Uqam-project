package com.mindsoft.immobilierproject.repository;

import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {
    Proprietaire findByUser(User user);
}
