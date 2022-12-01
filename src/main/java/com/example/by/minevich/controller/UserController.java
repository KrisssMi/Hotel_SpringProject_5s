package com.example.by.minevich.controller;

import com.example.by.minevich.dto.DateRequest;
import com.example.by.minevich.dto.IdBookingRequest;
import com.example.by.minevich.dto.UserBookingRequestNoId;
import com.example.by.minevich.exception.ControllerException;
import com.example.by.minevich.exception.RepositoryException;
import com.example.by.minevich.exception.ServiceException;
import com.example.by.minevich.models.BookingForm;
import com.example.by.minevich.repositories.UserBookingFormRepository;
import com.example.by.minevich.service.RoomService;
import com.example.by.minevich.service.UserBookingFormService;
import com.example.by.minevich.validator.BookingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserBookingFormService userBookingFormService;
    @Autowired
    private UserBookingFormRepository userBookingFormRepository;
    @Autowired
    private RoomService roomService;
    @Autowired
    private BookingValidator bookingValidator;

    @PostMapping("/admin/getAllByRoomBookingDateLessThan")
    public ResponseEntity<?> getAllByRoomBookingDateLessThan(@RequestBody DateRequest dateRequest) throws ControllerException {
        try {
            return new ResponseEntity<>(userBookingFormService.getAllByRoomBookingDateLessThan(dateRequest.getDate()), HttpStatus.FOUND);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @DeleteMapping("/admin/deleteByUserIdAndRoomId")
    public ResponseEntity<?> deleteByUserIdAndRoomId() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/admin/setUserBookingFormById")
    public ResponseEntity<?> setUserBookingFormById(@RequestBody IdBookingRequest idBookingRequest) throws ControllerException {
        try {
            BookingForm bookingForm = userBookingFormService.getById(idBookingRequest.getId());
            userBookingFormService.setUserBookingFormById(idBookingRequest.getId(), idBookingRequest.isBooking());
            return new ResponseEntity<>(bookingForm, HttpStatus.OK);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping("/user/getAllByUserId/{id}")
    public ResponseEntity<?> getAllByUserId(@PathVariable(name="id") Long id) throws ControllerException {
        try {
            return new ResponseEntity<>(userBookingFormService.getAllByUserId(id), HttpStatus.FOUND);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping("/admin/getAllByBooking/{data}")
    public ResponseEntity<?> getAllByBooking(@PathVariable(name="data") boolean data) throws ControllerException {
        try {
            return new ResponseEntity<>(userBookingFormService.getAllByBooking(data), HttpStatus.FOUND);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @PostMapping("/admin/isUserBookingExistByRoomId")
    public ResponseEntity<?> isUserBookingExistByRoomId(@RequestBody IdBookingRequest idBookingRequest) throws ControllerException {
        try {
            if (userBookingFormService.existsByRoomId(idBookingRequest.getId())) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @PostMapping("/user/isUserBookingExistByUserId")
    public ResponseEntity<?> isUserBookingExistByUserId(@RequestBody IdBookingRequest idBookingRequest) throws ControllerException {
        try {
            if (!userBookingFormRepository.existsByUserId(idBookingRequest.getId())) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FOUND);
    }
        catch (RepositoryException e) {
            throw new ControllerException(e);
        }
    }

    @PostMapping("/user/createUserBooking")
    public ResponseEntity<?> createUserBooking(@RequestBody @Validated UserBookingRequestNoId userBookingRequestNoId, BindingResult bindingResult) throws ControllerException {
        if (!bindingResult.hasErrors()) {
            BookingForm userBookingForm = new BookingForm(
                    userBookingRequestNoId.getUser(),
                    userBookingRequestNoId.getName(),
                    userBookingRequestNoId.getSurname(),
                    userBookingRequestNoId.getRoom()
            );
            try {
                BookingForm test=new BookingForm();
                test.setId(15L);
                bookingValidator.validate(test, bindingResult);
                if(bindingResult.hasErrors()) throw new ControllerException("not correct data");
                userBookingFormService.create(userBookingForm);
                return new ResponseEntity<>(userBookingForm, HttpStatus.OK);
            }
            catch (Exception e) {
                throw new ControllerException(e);
            }
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
