package com.ibm.academy.cinema.apirest.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class FilmDto {

    private Long id;

    private String title;

    private String description;

    private List<CategoryDto> categories;

    private List<ActorDto> actors;

    private List<DirectorDto> directors;

}
