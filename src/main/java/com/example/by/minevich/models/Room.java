package com.example.by.minevich.models;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "room")
@Data
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int capacity;

    @Column
    private int cost;

    @Column
    private Date bookingDate;

    public Room(){}

    public Room(String name, String description, int capacity, int cost, Date date)
    {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.cost = cost;
        this.bookingDate = date;
    }
}
