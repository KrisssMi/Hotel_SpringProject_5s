package com.example.by.minevich.service;

import com.example.by.minevich.exception.RepositoryException;
import com.example.by.minevich.exception.ServiceException;
import com.example.by.minevich.models.Room;
import com.example.by.minevich.repositories.RoomRepository;
import com.example.by.minevich.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room create(Room room) throws ServiceException {
        return roomRepository.save(room);
    }

    @Override
    public boolean existsByName(String name) throws ServiceException {
        try {
            return roomRepository.existsByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Room> getAll() throws ServiceException {
        return roomRepository.findAll();
    }

    @Override
    public void deleteByName(String name) throws ServiceException {
        try {
            roomRepository.deleteByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Room getById(Long id) throws ServiceException {
        try {
            return roomRepository.getById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Room getByName(String name) throws ServiceException {
        try {
            return roomRepository.getByName(name);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateRoomById(Long id, String name, String description, int capacity, int cost) throws ServiceException {
        try {
            roomRepository.updateRoomById(id, name, description,capacity, cost);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
