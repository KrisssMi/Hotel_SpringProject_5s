package com.example.by.minevich.services.impl;

import com.example.by.minevich.models.UsersEntity;
import com.example.by.minevich.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthAndRegServiceImpl {
    UserRoleRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthAndRegServiceImpl(UserRoleRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register (UsersEntity usersEntity) throws Exception {
        if (userRepository.findByUserLogin(usersEntity.getUserLogin()).isPresent()) {
            throw new Exception("User with this name already exists");
        }
        usersEntity.setUserPassword(passwordEncoder.encode(usersEntity.getUserPassword()));
        userRepository.save(usersEntity);
    }
}
