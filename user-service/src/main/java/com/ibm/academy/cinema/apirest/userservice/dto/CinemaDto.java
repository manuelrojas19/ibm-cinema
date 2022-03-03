package com.ibm.academy.cinema.apirest.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto extends UserDto {

    @NotBlank
    @Size(max = 200)
    private String web;

    @NotBlank
    @Size(max = 200)
    private String address;
}
