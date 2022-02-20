package com.mindsoft.immobilierproject.service;

import com.mindsoft.immobilierproject.model.Professionnel;
import com.mindsoft.immobilierproject.model.User;
import com.mindsoft.immobilierproject.repository.ProfessionnelRepository;
import com.mindsoft.immobilierproject.repository.RoleRepository;
import com.mindsoft.immobilierproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionnelServiceImpl implements ProfessionnelService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProfessionnelRepository professionnelRepository;

    @Override
    public Professionnel create(Professionnel professionnel) {
        userRepository.save(professionnel.getUser());
        return this.professionnelRepository.save(professionnel);
    }

    @Override
    public Professionnel find(Long id) {
        return this.professionnelRepository.findById(id).get();
    }

    @Override
    public Professionnel findByUser(User user) {
        return professionnelRepository.findByUser(user);
    }

    @Override
    public boolean delete(Long id) {
        if (!this.professionnelRepository.existsById(id)) {
            return false;
        } else {
            professionnelRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public boolean updatePassword(String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public List<Professionnel> findAll() {
        return professionnelRepository.findAll();
    }
}
