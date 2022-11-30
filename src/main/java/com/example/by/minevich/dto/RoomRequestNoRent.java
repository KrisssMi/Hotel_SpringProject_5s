package com.example.by.minevich.dto;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
public class RoomRequestNoRent {
    private Long id;
    private String name;
    private String description;
    private int capacity;
    private int cost;
    private Date bookingDate;
}
