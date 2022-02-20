package com.mindsoft.immobilierproject.service;

import java.util.List;

import com.mindsoft.immobilierproject.model.Professionnel;
import com.mindsoft.immobilierproject.model.User;

public interface ProfessionnelService {

    Professionnel create(Professionnel professionnel);

    Professionnel find(Long id);

    Professionnel findByUser(User user);

    boolean delete(Long id);

    boolean updatePassword(String oldPassword, String newPassword);

    List<Professionnel> findAll();
}
