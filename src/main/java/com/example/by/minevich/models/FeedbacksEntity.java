package com.example.by.minevich.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "feedbacks")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbacksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Basic
    @Column(name = "HotelId")
    private int hotelId;

    @Basic
    @Column(name = "UserId")
    private int userId;

    @Basic
    @Column(name = "FeedbackDate")
    private Date feedbackDate;

    @Basic
    @Column(name = "Comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    private UsersEntity usersByUserId;

    @ManyToOne
    @JoinColumn(name = "HotelId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    private HotelsEntity hotelsByHotelId;
}