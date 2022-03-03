package com.ibm.academy.cinema.apirest.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class FilmListDto {

    private Long id;

    private String username;

    private String title;

    private String description;

    private List<FilmDto> films;

}
