package com.example.by.minevich.exception;

public class NonExistedUserException extends RuntimeException{
    public NonExistedUserException(String message) {
        super(message);
    }
}
