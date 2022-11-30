package com.example.by.minevich.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
@Data
@Getter
@Setter
public class BookingForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String userName;

    @Column
    private String userSurname;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column
    private boolean booking;

    public BookingForm(){}

    public BookingForm(User user, String userName, String userSurname, Room room)
    {
        this.user = user;
        this.userName = userName;
        this.userSurname = userSurname;
        this.room = room;
    }
}