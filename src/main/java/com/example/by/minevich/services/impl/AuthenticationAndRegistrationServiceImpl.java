package com.example.by.minevich.services.impl;

import com.example.by.minevich.models.UsersEntity;
import com.example.by.minevich.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationAndRegistrationServiceImpl {
    UserRepository usersRepository;

    @Autowired
    public AuthenticationAndRegistrationServiceImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(String username, String email, String password) throws Exception {
        List<UsersEntity> users = usersRepository.findAll();
        if (users.stream().filter(x -> x.geteMail().equals(email)).count() != 0) {
            throw new Exception("User has already registered email");
        }
        if (users.stream().filter(x -> x.getUserLogin().equals(username)).count() != 0) {
            throw new Exception("User has already registered username");
        }
        if (usersRepository.countRows() == 0)
            usersRepository.add(true, username, passwordEncoder.encode(password),
                    email);
        else
            usersRepository.add(false, username, passwordEncoder.encode(password),
                    email);

        Optional<UsersEntity> userInserted = usersRepository.findByName(username);
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Optional<UsersEntity> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UsersEntity> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void editUser(UsersEntity user) {
        userRepository.update(Math.toIntExact(user.getId()), user.isAdmin(), user.getUserLogin(), user.getUserPassword(), user.geteMail());
    }

    @Override
    public List<UsersEntity> getAll() {
        return userRepository.findAll();
    }
}