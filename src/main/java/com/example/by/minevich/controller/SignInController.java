package com.example.by.minevich.controller;

import com.example.by.minevich.logging.Loggable;
import com.example.by.minevich.services.impl.AuthAndRegServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SignInController {
    private final AuthAndRegServiceImpl usersService;
    AuthenticationManager authenticationManager;

    @Autowired
    public SignInController(AuthAndRegServiceImpl usersService, AuthenticationManager authenticationManager) {
        this.usersService = usersService;
        this.authenticationManager = authenticationManager;
    }

    @Loggable
    @GetMapping(value = {"/login"})
    public ModelAndView loginMain(Model model) {
        return new ModelAndView("login");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<Object, Object>> handleException(Exception ex) {
        Map<Object, Object> response = new HashMap<>();
        response.put("errorMessage", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = {"/login"})
    public void userPostLogin()
    {
    }
}
