package com.example.by.minevich.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithToken {
    private String login;
    private Boolean isAdmin;
    private String token;
}
