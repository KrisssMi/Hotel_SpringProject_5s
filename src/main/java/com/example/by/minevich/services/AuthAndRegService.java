package com.example.by.minevich.services;

import com.example.by.minevich.models.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface AuthAndRegService {
    void register(String username, String email, String password) throws Exception;
    void delete(int id);
    Optional<UsersEntity> getById(int id);
    Optional<UsersEntity> findByName(String name);
    void editUser(UsersEntity user);
    List<UsersEntity> getAll();
}
