package com.mindsoft.immobilierproject.repository;

import com.mindsoft.immobilierproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}