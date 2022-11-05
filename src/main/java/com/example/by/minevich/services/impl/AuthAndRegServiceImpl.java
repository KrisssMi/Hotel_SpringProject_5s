package com.example.by.minevich.services.impl;

import com.example.by.minevich.models.UsersEntity;
import com.example.by.minevich.repositories.UserRepository;
import com.example.by.minevich.services.AuthAndRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthAndRegServiceImpl implements AuthAndRegService {
    UserRepository userRepository;

    @Autowired
    public AuthAndRegServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(String username, String email, String password) throws Exception {
        List<UsersEntity> users = userRepository.findAll();
        if (users.stream().filter(x -> x.getEMail().equals(email)).count() != 0) {
            throw new Exception("User has already registered email");
        }
        if (users.stream().filter(x -> x.getUserLogin().equals(username)).count() != 0) {
            throw new Exception("User has already registered username");
        }
        if (userRepository.countRows() == 0)
            userRepository.add(true, username, password, email);
        else
            userRepository.add(false, username, password, email);
    Optional<UsersEntity> userInserted = userRepository.findByName(username);
}

    @Override
    public void delete(int id) {
    }

    @Override
    public void editUser(UsersEntity user) {
    userRepository.update(Math.toIntExact(user.getId()),user.isAdmin(),user.getUserLogin(), user.getUserPassword(),user.getEMail());
    }

    @Override
    public List<UsersEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UsersEntity> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UsersEntity> findByName(String name) {
        return userRepository.findByName(name);
    }
}
