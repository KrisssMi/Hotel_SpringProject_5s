package com.example.by.minevich.services;

import com.example.by.minevich.models.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface AuthAndRegService {
    void register(String username, String email, String password) throws Exception;
    public void delete(int id);
    public Optional<UsersEntity> getById(int id);
    public Optional<UsersEntity> findByName(String name);
    public void editUser(UsersEntity user);
    public List<UsersEntity> getAll();
    }
