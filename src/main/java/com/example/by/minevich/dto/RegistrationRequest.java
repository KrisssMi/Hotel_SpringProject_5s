package com.example.by.minevich.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Data
@Getter
@Setter
public class RegistrationRequest {
    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;
}
