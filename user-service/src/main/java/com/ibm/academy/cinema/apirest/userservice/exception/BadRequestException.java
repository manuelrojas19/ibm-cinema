package com.ibm.academy.cinema.apirest.userservice.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg) {
        super(msg);
    }
}
