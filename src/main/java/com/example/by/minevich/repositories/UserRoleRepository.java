package com.example.by.minevich.repositories;

import com.example.by.minevich.models.Role;
import com.example.by.minevich.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByName(Role name);
}