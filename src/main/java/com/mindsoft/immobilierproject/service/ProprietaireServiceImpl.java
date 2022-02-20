package com.mindsoft.immobilierproject.service;

import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.model.User;
import com.mindsoft.immobilierproject.repository.ProprietaireRepository;
import com.mindsoft.immobilierproject.repository.RoleRepository;
import com.mindsoft.immobilierproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietaireServiceImpl implements ProprietaireService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProprietaireRepository proprietaireRepository;

    @Override
    public Proprietaire create(Proprietaire proprietaire) {
        userRepository.save(proprietaire.getUser());
        return this.proprietaireRepository.save(proprietaire);
    }

    @Override
    public Proprietaire find(Long id) {
        return this.proprietaireRepository.findById(id).get();
    }

    @Override
    public Proprietaire findByUser(User user) {
        return proprietaireRepository.findByUser(user);
    }

    @Override
    public boolean delete(Long id) {
        if (!this.proprietaireRepository.existsById(id)) {
            return false;
        } else {
            proprietaireRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public boolean updatePassword(String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public List<Proprietaire> findAll() {
        return proprietaireRepository.findAll();
    }
}
