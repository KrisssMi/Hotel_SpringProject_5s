package com.example.by.minevich.exception;

public class ControllerException extends Exception {
    public ControllerException() {
        super();
    }
    public ControllerException(String message) {
        super(message);
    }
    public ControllerException(Exception e) {
        super(e);
    }
    public ControllerException(String message, Exception e) {
        super(message, e);
    }
}
