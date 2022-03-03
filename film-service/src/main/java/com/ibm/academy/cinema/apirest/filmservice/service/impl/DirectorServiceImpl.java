package com.ibm.academy.cinema.apirest.filmservice.service.impl;

import com.ibm.academy.cinema.apirest.filmservice.entity.Director;
import com.ibm.academy.cinema.apirest.filmservice.repository.DirectorRepository;
import com.ibm.academy.cinema.apirest.filmservice.service.DirectorService;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl extends GenericServiceImpl<Director, DirectorRepository> implements DirectorService {

    public DirectorServiceImpl(DirectorRepository repository) {
        super(repository);
    }

    @Override
    public Director update(Long id, Director director) {
        return null;
    }
}
