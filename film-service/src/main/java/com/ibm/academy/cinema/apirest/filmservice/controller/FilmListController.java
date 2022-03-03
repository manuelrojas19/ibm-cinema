package com.ibm.academy.cinema.apirest.filmservice.controller;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import com.ibm.academy.cinema.apirest.filmservice.entity.FilmList;
import com.ibm.academy.cinema.apirest.filmservice.service.FilmListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/film-lists")
public class FilmListController {

    @Autowired
    private FilmListService service;

    /**
     * Endpoint que permite a cualquier usuario registrado o no registrado recuperar la oferta de Películas
     * disponibles.
     * @return ResponseEntity con la lista de películas disponibles.
     */

    @PreAuthorize("hasAuthority('SUBSCRIBER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<FilmList> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PreAuthorize("hasAuthority('SUBSCRIBER') or hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<FilmList> create(@RequestBody FilmList filmList) {
        return ResponseEntity.ok(service.save(filmList));
    }

    @PreAuthorize("hasAuthority('SUBSCRIBER') or hasAuthority('ADMIN')")
    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<List<FilmList>> findAllByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.findAllByUsername(username));
    }

    /**
     * Endpoint que permite a un administrador enlazar una película con una categoría.
     *
     * @param filmId Id del film
     * @param filmListId Id de la lista de films
     * @return ResponseEntity con el status de la solicitud.
     */
    @PreAuthorize("hasAuthority('SUBSCRIBER') or hasAuthority('ADMIN')")
    @PutMapping("/{filmListId}/addFilm/{filmId}")
    public ResponseEntity<FilmList> addFilmToFilmList(@PathVariable Long filmListId, @PathVariable Long filmId) {
        return ResponseEntity.accepted().body(service.addFilmToFilmList(filmId, filmListId));
    }

}
