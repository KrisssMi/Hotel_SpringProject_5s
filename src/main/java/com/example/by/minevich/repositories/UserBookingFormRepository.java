package com.example.by.minevich.repositories;


import com.example.by.minevich.exception.RepositoryException;
import com.example.by.minevich.exception.ServiceException;
import com.example.by.minevich.models.BookingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserBookingFormRepository extends JpaRepository<BookingForm, Long> {
    @Modifying
    void deleteById(int id);

    @Modifying
    void deleteByUserIdAndRoomId(Long user_id, Long room_id) throws RepositoryException;

    @Modifying
    @Transactional
    void deleteByUserName(String userName) throws RepositoryException;

    BookingForm getById(Long id);

    List<BookingForm> getAllByUserId(Long user_id) throws RepositoryException;

    boolean existsByRoomId(Long room_id) throws RepositoryException;

    boolean existsByUserId(Long user_id) throws RepositoryException;

    List<BookingForm> getAllByBooking(boolean booking) throws RepositoryException;

    List<BookingForm> getAllByRoomBookingDateLessThan(String room_bookingDate) throws RepositoryException;

    @Modifying
    @Query("update BookingForm urf set urf.booking =:booking  where urf.id =:id ")
    void setUserBookingFormById(@Param("id") Long id, @Param("booking") boolean booking) throws RepositoryException, ServiceException;
}

