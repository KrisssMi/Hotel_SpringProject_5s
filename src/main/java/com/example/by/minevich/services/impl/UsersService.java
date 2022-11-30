package com.example.by.minevich.services.impl;

import com.example.by.minevich.models.UsersEntity;
import com.example.by.minevich.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private final UserRoleRepository usersRepository;

    @Autowired
    public UsersService(UserRoleRepository usersRepository) {
        this.usersRepository = usersRepository;
    }



    public Optional<UsersEntity> findByName(String name) {
        return usersRepository.findByUserLogin(name);
    }
}
