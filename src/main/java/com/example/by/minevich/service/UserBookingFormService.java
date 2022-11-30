package com.example.by.minevich.service;

import com.example.by.minevich.exception.RepositoryException;
import com.example.by.minevich.exception.ServiceException;
import com.example.by.minevich.models.BookingForm;
import com.example.by.minevich.repositories.UserBookingFormRepository;
import com.example.by.minevich.service.interfaces.IUserBookingFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserBookingFormService implements IUserBookingFormService {
    @Autowired
    private UserBookingFormRepository userBookingFormRepository;

    @Override
    public void deleteById(Long id) {
userBookingFormRepository.deleteById(id);
}

    @Override
    public void deleteByUserIdAndRoomId(Long user_id, Long room_id) throws ServiceException {
        try {
            userBookingFormRepository.deleteByUserIdAndRoomId(user_id, room_id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public BookingForm create(BookingForm bookingForm) {
        return userBookingFormRepository.save(bookingForm);
    }

    @Override
    public boolean existsByRoomId(Long room_id) throws ServiceException {
        try {
            return userBookingFormRepository.existsByRoomId(room_id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public BookingForm getById(Long id) throws ServiceException {
        return userBookingFormRepository.getById(id);
    }

    @Override
    public List<BookingForm> getAllByUserId(Long user_id) throws ServiceException {
        try {
            return userBookingFormRepository.getAllByUserId(user_id);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<BookingForm> getAllByBooking(boolean booking) throws ServiceException {
        try {
            return userBookingFormRepository.getAllByBooking(booking);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<BookingForm> getAllByRoomBookingDateLessThan(Date room_bookingDate) throws ServiceException {
        try {
            return userBookingFormRepository.getAllByRoomBookingDateLessThan(room_bookingDate);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void setUserBookingFormById(Long id, boolean booking) throws ServiceException {
        try {
            userBookingFormRepository.setUserBookingFormById(id, booking);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
