package com.ibm.academy.cinema.apirest.filmservice.controller;

import com.ibm.academy.cinema.apirest.filmservice.entity.Category;
import com.ibm.academy.cinema.apirest.filmservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    /**
     * Endpoint que permite a cualquier usuario registrado o no registrado recuperar la oferta de Películas
     * disponibles.
     * @return ResponseEntity con la lista de películas disponibles.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = service.findAll();
        return ResponseEntity.ok(categories);
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN crear una categoria.
     * @param category Película a registrar
     * @return ResponseEntity con el status de la solicitud y la película registrada
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.ok(service.save(category));
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN actualizar los datos de una película.
     *
     * @param id Id de la película a modificar.
     * @param category Datos de la película.
     * @return ResponseEntity con el status de la solicitud.
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        return ResponseEntity.accepted().body(service.update(id, category));
    }

    /**
     * Endpoint que permite a un usuario con el rol ADMIN eliminar una película.
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
