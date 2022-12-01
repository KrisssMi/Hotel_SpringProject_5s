package com.example.by.minevich.service.interfaces;

import com.example.by.minevich.models.Room;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public interface IRoomService {
    @Transactional
    void deleteById(Long id) throws ServiceException;

    Room create(Room room) throws ServiceException, com.example.by.minevich.exception.ServiceException;

    boolean existsByName(String name) throws ServiceException, com.example.by.minevich.exception.ServiceException;

    List<Room> getAll() throws ServiceException, com.example.by.minevich.exception.ServiceException;

    @Transactional
    void deleteByName(String name) throws ServiceException, com.example.by.minevich.exception.ServiceException;

    Room getById(Long id) throws ServiceException, com.example.by.minevich.exception.ServiceException;

    Room getByName(String name) throws ServiceException, com.example.by.minevich.exception.ServiceException;

    @Transactional
    void updateRoomById(
            Long id,
            String name,
            String description,
            int capacity,
            int cost) throws ServiceException, com.example.by.minevich.exception.ServiceException;
}
