package com.mindsoft.immobilierproject.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindsoft.immobilierproject.model.Role;
import com.mindsoft.immobilierproject.model.User;
import com.mindsoft.immobilierproject.repository.RoleRepository;
import com.mindsoft.immobilierproject.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<>(roleRepository.findAll()));
        
//        Role roleUser = roleRepository.findByName("USER");
//        user.addRole(roleUser);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}
}