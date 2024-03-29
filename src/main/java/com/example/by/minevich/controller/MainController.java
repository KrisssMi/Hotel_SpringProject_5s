package com.example.by.minevich.controller;

import com.example.by.minevich.config.MailConfig;
import com.example.by.minevich.dto.AuthRequest;
import com.example.by.minevich.dto.AuthResponse;
import com.example.by.minevich.dto.RegistrationRequest;
import com.example.by.minevich.dto.UserResponse;
import com.example.by.minevich.exception.ControllerException;
import com.example.by.minevich.jwt.JwtProvider;
import com.example.by.minevich.models.User;
import com.example.by.minevich.service.MailSender;
import com.example.by.minevich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    MailSender mailSender;

    @PostMapping("/users")
    public List<User> getUsers() throws ControllerException {
        try {
            System.out.println("getting all users");
            return userService.findAll();
        } catch (Exception e) {
            System.out.println("error get all users");
            throw new ControllerException("getUsers", e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthRequest authRequest) throws ControllerException
    {
        try{
            System.out.println("try to login user");

            User user = userService.findByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword());
            if(user != null)
            {
                String token = jwtProvider.generateToken(user.getLogin());
                AuthResponse response = new AuthResponse(token, user.getUserRole().getName());
                System.out.println(user.getUserRole().getName());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else
            {
                throw new ControllerException("not such user");
            }
        } catch (ControllerException e) {
            System.out.println("error login");

            throw new ControllerException("No such user with this credentials", e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest)
    {
        System.out.println("try to register user");
        if(!userService.existsUserByLogin(registrationRequest.getLogin()))
        {
            User user = new User();
            user.setPassword(registrationRequest.getPassword());
            user.setLogin(registrationRequest.getLogin());
            user.setEmail(registrationRequest.getEmail());
            user.setActive(true);
            user.setActivationCode(UUID.randomUUID().toString());
            userService.saveUser(user);
            if(!user.getEmail().isEmpty()){
                String message = String.format("Hello, %s!\n " +
                                "Welcome to my Java project!",
                        user.getLogin(), user.getActivationCode());
                mailSender.sendMail(user.getEmail(), "Activation code", message);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }

    @PostMapping("/authorized")
    public ResponseEntity<?> isAuthorized() throws ControllerException {
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/getUser")
    public UserResponse getUser(@RequestHeader(name = "Authorisation") String jwt) throws ControllerException {
        try {
            String userName = jwtProvider.getLoginFromToken(jwt.substring(7));
            User user = userService.findByLogin(userName);

            return new UserResponse(user.getId(), user.getLogin(), user.getUserRole().getName());
        } catch (Exception e) {
            throw new ControllerException("getUser", e);
        }
    }
}
