package com.ibm.academy.cinema.apirest.userservice.repository;

import com.ibm.academy.cinema.apirest.userservice.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
