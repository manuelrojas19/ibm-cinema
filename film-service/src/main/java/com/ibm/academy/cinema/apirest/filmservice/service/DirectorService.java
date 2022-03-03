package com.ibm.academy.cinema.apirest.filmservice.service;

import com.ibm.academy.cinema.apirest.filmservice.entity.Director;

public interface DirectorService extends GenericService<Director> {
    Director update(Long id, Director director);
}
