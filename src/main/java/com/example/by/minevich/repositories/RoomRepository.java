package com.example.by.minevich.repositories;


import com.example.by.minevich.exception.RepositoryException;
import com.example.by.minevich.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Modifying
    void deleteById(int id) throws RepositoryException;

    @Modifying
    void deleteByName(String name) throws RepositoryException;

    Room getById(Long id);

    Room getByName(String name) throws RepositoryException;

    boolean existsByName(String name) throws RepositoryException;

    @Modifying
    @Query("update Room c set c.name=:name, c.description=:description, c.cost=:cost where c.id=:id")
    void updateRoomById(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("description") String description,
            @Param("cost") int cost
    ) throws RepositoryException;
}