package com.example.by.minevich.repositories;

import com.example.by.minevich.models.HotelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HotelsRepository extends JpaRepository<HotelsEntity, Long> {
    @Query(value = "SELECT * FROM Hotels where Rooms = :i ",nativeQuery = true)
    Optional<HotelsEntity> findByName(@Param("i") int i);
}
