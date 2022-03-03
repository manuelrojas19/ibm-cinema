package com.ibm.academy.cinema.apirest.filmservice.service.impl;

import com.ibm.academy.cinema.apirest.filmservice.entity.Actor;
import com.ibm.academy.cinema.apirest.filmservice.entity.Category;
import com.ibm.academy.cinema.apirest.filmservice.entity.Director;
import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import com.ibm.academy.cinema.apirest.filmservice.exception.BadRequestException;
import com.ibm.academy.cinema.apirest.filmservice.repository.ActorRepository;
import com.ibm.academy.cinema.apirest.filmservice.repository.CategoryRepository;
import com.ibm.academy.cinema.apirest.filmservice.repository.DirectorRepository;
import com.ibm.academy.cinema.apirest.filmservice.repository.FilmRepository;
import com.ibm.academy.cinema.apirest.filmservice.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilmServiceImpl extends GenericServiceImpl<Film, FilmRepository> implements FilmService {

    public static final String DIRECTOR_ALREADY_ADDED_ERROR_MSG = "This director has already been added to this movie";
    public static final String ACTOR_ALREADY_ADDED_ERROR_MSG = "This actor has already been added to this movie";
    public static final String CATEGORY_ALREADY_ADDED_ERROR_MSG = "This category has already been added to this movie";

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Film update(Long id, Film film) {
        Film filmToUpdate = repository.findById(id).orElseThrow();
        filmToUpdate.setTitle(film.getTitle());
        filmToUpdate.setDescription(film.getDescription());
        filmToUpdate.setDate(filmToUpdate.getDate());
        return repository.save(filmToUpdate);
    }

    @Override
    @Transactional
    public Film addDirectorToFilm(Long categoryId, Long filmId) {
        Film film = repository.findById(filmId).orElseThrow();
        Director director = directorRepository.findById(categoryId).orElseThrow();
        if (film.getDirectors().contains(director))
            throw new BadRequestException(DIRECTOR_ALREADY_ADDED_ERROR_MSG);
        film.getDirectors().add(director);
        return repository.saveAndFlush(film);
    }

    @Override
    @Transactional
    public Film addActorToFilm(Long actorId, Long filmId) {
        Film film = repository.findById(filmId).orElseThrow();
        Actor actor = actorRepository.findById(actorId).orElseThrow();
        if (film.getActors().contains(actor))
            throw new BadRequestException(ACTOR_ALREADY_ADDED_ERROR_MSG);
        film.getActors().add(actor);
        return repository.saveAndFlush(film);
    }

    @Override
    @Transactional
    public Film addCategoryToFilm(Long categoryId, Long filmId) {
        Film film = repository.findById(filmId).orElseThrow();
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        if (film.getCategories().contains(category))
            throw new BadRequestException(CATEGORY_ALREADY_ADDED_ERROR_MSG);
        film.getCategories().add(category);
        return repository.saveAndFlush(film);
    }
}
