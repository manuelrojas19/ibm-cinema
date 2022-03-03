package com.ibm.academy.cinema.apirest.filmservice.service;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;

public interface FilmService extends GenericService<Film> {
    Film addDirectorToFilm(Long directorId, Long filmId);
    Film addActorToFilm(Long actorId, Long filmId);
    Film addCategoryToFilm(Long categoryId, Long filmId);
    Film update(Long id, Film film);
}
