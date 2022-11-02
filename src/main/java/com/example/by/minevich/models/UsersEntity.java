package com.example.by.minevich.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "IsAdmin")
    private boolean isAdmin;

    @Column(name = "UserLogin")
    private String userLogin;

    @Column(name = "UserPassword")
    private String userPassword;

    @Column(name = "EMail")
    private String eMail;
}
