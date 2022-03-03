package com.ibm.academy.cinema.apirest.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscribers")
public class SubscriberController {

    @PreAuthorize("hasAuthority('SUBSCRIBER')")
    @GetMapping("/findMovieList")
    public ResponseEntity<?> findAllFilmLists() {
        return ResponseEntity.ok().build();
    }
}
