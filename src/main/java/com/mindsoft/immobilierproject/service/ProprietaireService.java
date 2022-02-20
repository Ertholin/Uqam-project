package com.mindsoft.immobilierproject.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.model.User;

import java.util.List;

public interface ProprietaireService {

    Proprietaire create(Proprietaire proprietaire);

    Proprietaire find(Long id);

    Proprietaire findByUser(User user);

    boolean delete(Long id);

    boolean updatePassword(String oldPassword, String newPassword);

    List<Proprietaire> findAll();
}
