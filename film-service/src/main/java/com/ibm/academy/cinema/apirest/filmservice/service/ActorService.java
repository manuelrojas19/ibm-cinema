package com.ibm.academy.cinema.apirest.filmservice.service;

import com.ibm.academy.cinema.apirest.filmservice.entity.Actor;

public interface ActorService extends GenericService<Actor> {
    Actor update(Long id, Actor actor);
}
