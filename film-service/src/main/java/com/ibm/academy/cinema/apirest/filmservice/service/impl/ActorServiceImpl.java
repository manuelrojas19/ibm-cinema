package com.ibm.academy.cinema.apirest.filmservice.service.impl;

import com.ibm.academy.cinema.apirest.filmservice.entity.Actor;
import com.ibm.academy.cinema.apirest.filmservice.repository.ActorRepository;
import com.ibm.academy.cinema.apirest.filmservice.service.ActorService;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl extends GenericServiceImpl<Actor, ActorRepository> implements ActorService {

    public ActorServiceImpl(ActorRepository repository) {
        super(repository);
    }

    @Override
    public Actor update(Long id, Actor actor) {
        return null;
    }
}
