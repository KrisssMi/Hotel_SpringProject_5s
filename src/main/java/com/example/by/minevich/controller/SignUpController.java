package com.example.by.minevich.controller;

import com.example.by.minevich.repositories.UserRepository;
import com.example.by.minevich.services.impl.AuthAndRegServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;

@RestController
public class SignUpController {
    @Autowired
    private UserRepository usersEntityRepository;

    private final AuthAndRegServiceImpl usersService;
    @Autowired
    public SignUpController(AuthAndRegServiceImpl usersService) {
        this.usersService = usersService;
    }

    @PostMapping(value = {"/addUser"})
    public ModelAndView userPostAdd(@RequestParam (required = false) String username, @RequestParam(required = false) String email,  @RequestParam(required = false) String password, Model model) throws Exception {
        usersService.register(username,email, password);
        URI login = new URI("http://localhost:8080/signIn");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(login);
        return new ModelAndView("redirect:/index");
    }

    @GetMapping(value = {"/registration"})
    public ModelAndView registrationMain(Model model) {
        return new ModelAndView("registration");
    }
}
