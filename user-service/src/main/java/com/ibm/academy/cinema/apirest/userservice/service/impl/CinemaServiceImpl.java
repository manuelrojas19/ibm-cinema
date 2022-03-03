package com.ibm.academy.cinema.apirest.userservice.service.impl;

import com.ibm.academy.cinema.apirest.userservice.dto.CinemaDto;
import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;
import com.ibm.academy.cinema.apirest.userservice.entity.Cinema;
import com.ibm.academy.cinema.apirest.userservice.mapper.UserMapper;
import com.ibm.academy.cinema.apirest.userservice.repository.UserRepository;
import com.ibm.academy.cinema.apirest.userservice.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CinemaDto create(UserDto cinemaDto) {
        Cinema cinema = (Cinema) mapper.toEntity(cinemaDto);
        if (userRepository.existsByEmail(cinemaDto.getEmail())
                || userRepository.existsByUsername(cinemaDto.getUsername()))
            throw new RuntimeException("Conflict");
        cinema.setPassword(passwordEncoder.encode(cinema.getPassword()));
        return mapper.toDto(userRepository.save(cinema));
    }
}
