package com.ibm.academy.cinema.apirest.filmservice.service.impl;

import com.ibm.academy.cinema.apirest.filmservice.exception.NotFoundException;
import com.ibm.academy.cinema.apirest.filmservice.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenericServiceImpl<E, R extends JpaRepository<E, Long>> implements GenericService<E> {

    protected final R repository;
    public static final String NOT_FOUND_ERROR_MSG = "No se encontraron recursos";

    public GenericServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public E findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new NotFoundException(NOT_FOUND_ERROR_MSG));
    }

    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
