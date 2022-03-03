package com.ibm.academy.cinema.apirest.filmservice.service;

import com.ibm.academy.cinema.apirest.filmservice.entity.FilmList;

import java.util.List;

public interface FilmListService extends GenericService<FilmList> {
    List<FilmList> findAllByUsername(String username);
    FilmList addFilmToFilmList(Long filmId, Long filmListId);
}
