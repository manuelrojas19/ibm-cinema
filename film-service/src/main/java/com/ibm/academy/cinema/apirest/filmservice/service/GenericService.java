package com.ibm.academy.cinema.apirest.filmservice.service;

import java.util.List;

public interface GenericService<E> {
    E findById(Long id);
    E save(E entity);
    List<E> findAll();
    void deleteById(Long id);
}
