package com.ibm.academy.cinema.apirest.filmservice.controller;

import com.ibm.academy.cinema.apirest.filmservice.entity.Actor;
import com.ibm.academy.cinema.apirest.filmservice.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {

    @Autowired
    private ActorService service;

    /**
     * Endpoint que permite a cualquier usuario registrado o no registrado recuperar la oferta de Películas
     * disponibles.
     * @return ResponseEntity con la lista de películas disponibles.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Actor>> findAll() {
        List<Actor> actors = service.findAll();
        return ResponseEntity.ok(actors);
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN crear una categoría.
     *
     * @param actor Película a registrar
     * @return ResponseEntity con el status de la solicitud y la película registrada
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Actor> create(@RequestBody Actor actor) {
        log.debug("Actor to add: {}",  actor);
        return ResponseEntity.ok(service.save(actor));
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN actualizar los datos de una película.
     *
     * @param id Id de la película a modificar.
     * @param actor Datos de la película.
     * @return ResponseEntity con el status de la solicitud.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Actor> update(@PathVariable Long id, @RequestBody Actor actor) {
        return ResponseEntity.accepted().body(service.update(id, actor));
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN eliminar una película.
     *
     * @param id Id de la película a eliminar.
     * @return ResponseEntity con el estatus de la solicitud.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
