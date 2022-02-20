package com.mindsoft.immobilierproject.repository;

import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.model.Propriete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProprieteRepository extends JpaRepository<Propriete, Long> {
    List<Propriete> findByProprietaire(Proprietaire proprietaire);
}
