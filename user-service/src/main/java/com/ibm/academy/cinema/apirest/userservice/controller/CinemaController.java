package com.ibm.academy.cinema.apirest.userservice.controller;

import com.ibm.academy.cinema.apirest.userservice.dto.CinemaDto;
import com.ibm.academy.cinema.apirest.userservice.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    /**
     * Endpoint que permite a un usuario con el rol ADMIN registrar un cinema en la aplicación.
     * @param cinemaDto Datos del cine a registrar.
     * @return ResponseEntity con el status de la solicitud.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CinemaDto cinemaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cinemaService.create(cinemaDto));
    }
}
