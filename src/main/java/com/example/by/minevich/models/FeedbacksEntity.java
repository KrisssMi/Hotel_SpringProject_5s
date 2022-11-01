package com.example.by.minevich.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Feedbacks")
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
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "HotelId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    private HotelsEntity hotelsByHotelId;
    public HotelsEntity getHotelsByHotelId() {
        return hotelsByHotelId;
    }

    public void setHotelsByHotelId(HotelsEntity hotelsByHotelId) {
        this.hotelsByHotelId = hotelsByHotelId;
    }

    public FeedbacksEntity(int userId, int hotelId, Date feedbackDate, String comment) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.feedbackDate = feedbackDate;
        this.comment = comment;
    }

    public FeedbacksEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
