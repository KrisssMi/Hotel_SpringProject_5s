package com.example.by.minevich.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "hotels")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Rooms")
    private int rooms;

    @Column(name = "Rating")
    private BigDecimal rating;

    @Column(name = "Description")
    private String description;

    @Column(name = "Name")
    private String name;
}
