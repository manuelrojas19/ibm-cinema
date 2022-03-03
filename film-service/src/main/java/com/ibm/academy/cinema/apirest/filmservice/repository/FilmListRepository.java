package com.ibm.academy.cinema.apirest.filmservice.repository;

import com.ibm.academy.cinema.apirest.filmservice.entity.FilmList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmListRepository extends JpaRepository<FilmList, Long> {

    List<FilmList> findAllByUsername(String username);

    @PostAuthorize("hasAuthority('ADMIN') or" +
            "(hasAuthority('SUBSCRIBER') and " +
            "returnObject.empty ? true : (returnObject.get()).username == authentication.name)")
    Optional<FilmList> findById(Long filmList);

}
