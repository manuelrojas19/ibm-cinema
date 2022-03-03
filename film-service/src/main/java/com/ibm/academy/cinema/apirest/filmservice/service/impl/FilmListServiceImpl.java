package com.ibm.academy.cinema.apirest.filmservice.service.impl;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import com.ibm.academy.cinema.apirest.filmservice.entity.FilmList;
import com.ibm.academy.cinema.apirest.filmservice.exception.BadRequestException;
import com.ibm.academy.cinema.apirest.filmservice.exception.NotFoundException;
import com.ibm.academy.cinema.apirest.filmservice.repository.FilmListRepository;
import com.ibm.academy.cinema.apirest.filmservice.repository.FilmRepository;
import com.ibm.academy.cinema.apirest.filmservice.service.FilmListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmListServiceImpl extends GenericServiceImpl<FilmList, FilmListRepository>
        implements FilmListService {

    public static final String FILM_ALREADY_ADDED_ERROR_MSG = "This film is already added to this list";
    public static final String FILM_LIST_NOT_FOUND_ERROR_MSG = "FilmList was not found";
    public static final String FILM_NOT_FOUND_ERROR_MSG = "Film was not found";

    @Autowired
    private FilmRepository filmRepository;

    public FilmListServiceImpl(FilmListRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FilmList> findAllByUsername(String username) {
        return repository.findAllByUsername(username);
    }

    @Override
    @Transactional
    public FilmList save(FilmList filmList) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        filmList.setUsername(username);
        return repository.save(filmList);
    }

    @Override
    @Transactional
    public FilmList addFilmToFilmList(Long filmId, Long filmListId) {
        FilmList filmList = repository.findById(filmListId)
                .orElseThrow(() -> new NotFoundException(FILM_LIST_NOT_FOUND_ERROR_MSG));
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new NotFoundException(FILM_NOT_FOUND_ERROR_MSG));
        if (filmList.getFilms().contains(film))
            throw new BadRequestException(FILM_ALREADY_ADDED_ERROR_MSG);
        filmList.getFilms().add(film);
        return repository.saveAndFlush(filmList);
    }


}
