package com.ibm.academy.cinema.apirest.filmservice.controller;

import com.ibm.academy.cinema.apirest.filmservice.entity.Director;
import com.ibm.academy.cinema.apirest.filmservice.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directors")
public class DirectorController {

    @Autowired
    private DirectorService service;

    /**
     * Endpoint que permite a cualquier usuario registrado o no registrado recuperar la oferta de Películas
     * disponibles.
     *
     * @return ResponseEntity con la lista de películas disponibles.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Director>> findAll() {
        List<Director> directors = service.findAll();
        return ResponseEntity.ok(directors);
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN crear una categoría.
     *
     * @param director Película a registrar
     * @return ResponseEntity con el status de la solicitud y la película registrada
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Director> create(@RequestBody Director director) {
        return ResponseEntity.ok(service.save(director));
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN actualizar los datos de una película.
     *
     * @param id Id de la película a modificar.
     * @param director Datos de la película.
     * @return ResponseEntity con el status de la solicitud.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Director> update(@PathVariable Long id, @RequestBody Director director) {
        return ResponseEntity.accepted().body(service.update(id, director));
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
