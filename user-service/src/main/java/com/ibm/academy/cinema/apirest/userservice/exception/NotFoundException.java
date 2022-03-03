package com.ibm.academy.cinema.apirest.userservice.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg) {
        super(msg);
    }
}
