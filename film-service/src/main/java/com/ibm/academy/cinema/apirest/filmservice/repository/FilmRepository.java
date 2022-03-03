package com.ibm.academy.cinema.apirest.filmservice.repository;

import com.ibm.academy.cinema.apirest.filmservice.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
