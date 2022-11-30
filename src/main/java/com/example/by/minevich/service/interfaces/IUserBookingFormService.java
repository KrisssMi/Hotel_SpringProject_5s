package com.example.by.minevich.service.interfaces;

import com.example.by.minevich.exception.ServiceException;
import com.example.by.minevich.models.BookingForm;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface IUserBookingFormService {
    @Transactional
    void deleteById(Long id) throws ServiceException;

    @Transactional
    void deleteByUserIdAndRoomId(Long user_id, Long room_id) throws ServiceException;

    BookingForm create(BookingForm userBookingForm) throws ServiceException;

    boolean existsByRoomId(Long room_id) throws ServiceException;

    BookingForm getById(Long id) throws ServiceException;

    List<BookingForm> getAllByUserId(Long user_id) throws ServiceException;

    List<BookingForm> getAllByBooking(boolean booking) throws ServiceException;

    List<BookingForm> getAllByRoomBookingDateLessThan(Date room_bookingDate) throws ServiceException;

    @Transactional
    void setUserBookingFormById(Long id, boolean booking) throws ServiceException;
}
