package com.example.by.minevich.exception;

public class RepositoryException extends Exception {

    public RepositoryException() {
        super();
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(Exception e) {
        super(e);
    }

    public RepositoryException(String message, Exception e) {
        super(message, e);
    }
}
