package com.example.by.minevich.controller;

import com.example.by.minevich.dto.NameRequest;
import com.example.by.minevich.dto.RoomRequestNoIdRent;
import com.example.by.minevich.dto.RoomRequestNoRent;
import com.example.by.minevich.exception.ControllerException;
import com.example.by.minevich.exception.RepositoryException;
import com.example.by.minevich.exception.ServiceException;
import com.example.by.minevich.models.Room;
import com.example.by.minevich.repositories.UserBookingFormRepository;
import com.example.by.minevich.service.RoomService;
import com.example.by.minevich.service.UserBookingFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserBookingFormService userBookingFormService;
    @Autowired
    private UserBookingFormRepository userBookingFormRepository;

    @PostMapping("/admin/createRoom")
    public ResponseEntity<?> createScooter(@RequestBody RoomRequestNoIdRent roomRequestNoIdRent) throws ControllerException {
        Room room = new Room(
                roomRequestNoIdRent.getName(),
                roomRequestNoIdRent.getDescription(),
                roomRequestNoIdRent.getCapacity(),
                roomRequestNoIdRent.getCost(),
                roomRequestNoIdRent.getBookingDate()
        );
        try {
            roomService.create(room);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @DeleteMapping("/admin/deleteRoomByNameA")
    public ResponseEntity<?> deleteRoomByNameA(@RequestBody NameRequest nameRequest) throws ControllerException {
        try {
            Room room = roomService.getByName(nameRequest.getName());
            roomService.deleteByName(nameRequest.getName());
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @PutMapping("/admin/updateRoom")
    public ResponseEntity<?> updateScooter(@RequestBody RoomRequestNoRent RoomRequestNoRent)throws ControllerException {
        try {
            Room room = roomService.getById(RoomRequestNoRent.getId());
            roomService.updateRoomById(
                    RoomRequestNoRent.getId(), RoomRequestNoRent.getName(), RoomRequestNoRent.getDescription(),
                    RoomRequestNoRent.getCapacity(),
                    RoomRequestNoRent.getCost()
            );
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @DeleteMapping("/user/deleteRoomByNameU")
    public ResponseEntity<?> deleteRoomByNameU(@RequestBody NameRequest nameRequest)throws ControllerException {
        try {
            Room room = roomService.getByName(nameRequest.getName());
            userBookingFormRepository.deleteByUserName(nameRequest.getName());
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        catch (ServiceException | RepositoryException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping("/admin/getAllRoomsForAdmin")
    public ResponseEntity<?> getAllRoomsForAdmin() throws ControllerException{
        try {
            return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
        }
        catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @PostMapping("/admin/isRoomExistByName")
    public ResponseEntity<?> isRoomExistByName(@RequestBody NameRequest nameRequest) throws ControllerException {
        try {
            if (!roomService.existsByName(nameRequest.getName())) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FOUND);
            }
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping("/user/userGetRoomByName/{name}")
    public ResponseEntity<?> userGetRoomByName(@PathVariable(name = "name")String name)throws ControllerException {
        Room room=null;
        try {
            room = roomService.getByName(name);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping("admin/adminGetRoomByName/{name}")
    public ResponseEntity<?> adminGetRoomByName(@PathVariable(name = "name") String name) throws ParseException, ControllerException {
        Room room=null;
        try {
            room = roomService.getByName(name);
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(room.getBookingDate());
            System.out.println(date);
            room.setBookingDate(simpleDateFormat.parse(date));
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        catch (ServiceException e) {
            System.out.println("Error occured");
            throw new ControllerException(e);
        }
    }

    @GetMapping("/user/getAllRoomsForUser")
    public ResponseEntity<?> getAllRoomsForUser()throws ControllerException {
        try {
            return new ResponseEntity<>(roomService.getAll(),HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}
