package com.example.by.minevich.services.impl;

import com.example.by.minevich.models.UsersEntity;
import com.example.by.minevich.repositories.UserRepository;
import com.example.by.minevich.services.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements GeneralService<UsersEntity> {
    private UserRepository usersRepository;

    @Autowired
    public UsersService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void delete(int id) {
        usersRepository.deleteById((long) id);
    }

    @Override
    public Optional<UsersEntity> getById(int id) {
        return usersRepository.findById((long) id);
    }

    @Override
    public void editItem(UsersEntity item) {
        usersRepository.update(Math.toIntExact(item.getId()),item.isAdmin(),item.getUserLogin(),item.getUserPassword(),item.getUserLogin());
    }

    @Override
    public void add(UsersEntity item) {
        usersRepository.add(item.isAdmin(),item.getUserLogin(),item.getUserPassword(),item.getEMail());
    }

    @Override
    public int getCountRows() {
        return usersRepository.countRows();
    }

    @Override
    public int getCountRows(String search) {
        return usersRepository.countRows(search);
    }

    @Override
    public List<UsersEntity> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public List<UsersEntity> getPaginated(int min, int max) {
        return usersRepository.findPaginated(min,max);
    }

    @Override
    public List<UsersEntity> getPaginated(int min, int max, String search) {
        return usersRepository.findPaginated(min,max,search);
    }
    public Optional<UsersEntity> findByName(String name) {
        return usersRepository.findByName(name);
    }
}
