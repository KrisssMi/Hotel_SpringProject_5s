package com.example.by.minevich.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Hotels")
public class HotelsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Rooms")
    private int rooms;

    @Column(name = "Rating")
    private BigDecimal rating;

    @Column(name = "Description")
    private String description;

    @Column(name = "Name")
    private String name;

    public HotelsEntity(int rooms, BigDecimal rating, String description, String name) {
        this.rooms = rooms;
        this.rating = rating;
        this.description = description;
        this.name = name;
    }

    public HotelsEntity() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getRooms() {
        return rooms;
    }
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public BigDecimal getRating() {
        return rating;
    }
    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
