package com.example.by.minevich.security.jwt;

import com.example.by.minevich.logging.Loggable;
import com.example.by.minevich.models.UsersEntity;
import com.example.by.minevich.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtUserDetailsService implements UserDetailsService {
    UserRepository usersRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @SneakyThrows
    @Override
    @Loggable
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsersEntity> user = usersRepository.findByName(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        return JwtUserFactory.create(user.get());
    }
}
