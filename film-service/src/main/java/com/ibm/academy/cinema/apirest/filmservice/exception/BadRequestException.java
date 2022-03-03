package com.ibm.academy.cinema.apirest.filmservice.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}