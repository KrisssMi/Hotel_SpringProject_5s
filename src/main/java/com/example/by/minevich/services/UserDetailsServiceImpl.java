package com.example.by.minevich.services;

import com.example.by.minevich.models.UsersEntity;
import com.example.by.minevich.repositories.UserRoleRepository;
import com.example.by.minevich.security.jwt.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRoleRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRoleRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsersEntity> usersEntity = userRepository.findByUserLogin(username);

        if (usersEntity.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImpl(usersEntity.get());
    }
}