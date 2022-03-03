package com.ibm.academy.cinema.apirest.filmservice.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}