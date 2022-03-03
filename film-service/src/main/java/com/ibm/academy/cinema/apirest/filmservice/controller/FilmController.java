package com.ibm.academy.cinema.apirest.filmservice.controller;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import com.ibm.academy.cinema.apirest.filmservice.service.FilmService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    /**
     * Endpoint que permite a cualquier usuario registrado o no registrado recuperar la oferta de Películas
     * disponibles.
     * @return ResponseEntity con la lista de películas disponibles.
     */
    @GetMapping
    public ResponseEntity<List<Film>> findAll() {
        List<Film> films = filmService.findAll();
        return ResponseEntity.ok(films);
    }

    /**
     * Endpoint que permite a cualquier usuario registrado o no registrado recuperar la oferta de Películas
     * disponibles.
     * @return ResponseEntity con la lista de películas disponibles.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Film> findById(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.findById(id));
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN crear una película.
     * @param film Película a registrar
     * @return ResponseEntity con el status de la solicitud y la película registrada
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Film> create(@RequestBody Film film) {
        log.debug("Film to add: {}",  film);
        return ResponseEntity.ok(filmService.save(film));
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN actualizar los datos de una película.
     *
     * @param id Id de la película a modificar.
     * @param film Datos de la película.
     * @return ResponseEntity con el status de la solicitud.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Film> update(@PathVariable Long id, @RequestBody Film film) {
        return ResponseEntity.accepted().body(filmService.update(id, film));
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN eliminar una película.
     * @param id Id de la película a eliminar.
     * @return ResponseEntity con el estatus de la solicitud.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint que permite a un administrador enlazar una película con un actor.
     *
     * @param filmId Id del film
     * @param actorId Id del actor
     * @return ResponseEntity con el status de la solicitud.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{filmId}/addActor/{actorId}")
    public ResponseEntity<Film> addActorToFilm(@PathVariable Long filmId, @PathVariable Long actorId) {
        return ResponseEntity.accepted().body(filmService.addActorToFilm(actorId, filmId));
    }

    /**
     * Endpoint que permite a un administrador enlazar una película con una categoría.
     *
     * @param filmId Id del film
     * @param categoryId Id de la categoría
     * @return ResponseEntity con el status de la solicitud.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{filmId}/addCategory/{categoryId}")
    public ResponseEntity<Film> addCategoryToFILM(@PathVariable Long filmId, @PathVariable Long categoryId) {
        return ResponseEntity.accepted().body(filmService.addCategoryToFilm(categoryId, filmId));
    }

}
