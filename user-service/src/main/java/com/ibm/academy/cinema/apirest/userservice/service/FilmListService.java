package com.ibm.academy.cinema.apirest.userservice.service;

import com.ibm.academy.cinema.apirest.userservice.dto.FilmListDto;

public interface FilmListService {

    FilmListDto findAllByUsername(String username);
}
