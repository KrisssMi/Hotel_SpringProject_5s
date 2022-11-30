package com.example.by.minevich.dto;

import com.example.by.minevich.models.Room;
import com.example.by.minevich.models.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserBookingRequestNoId {
    @NotNull
    private User user;
    @NotNull
    @Size(min = 4 , message = "name from 4 ")
    private String name;
    @NotNull
    @Size(min = 4 , message = "surname from 4 ")
    private String surname;
    @NotNull
    private Room room;
}
