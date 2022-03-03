package com.ibm.academy.cinema.apirest.userservice.service;

import com.ibm.academy.cinema.apirest.userservice.dto.LoginRequestDto;
import com.ibm.academy.cinema.apirest.userservice.dto.LoginResponseDto;
import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;

public interface AuthService {

    UserDto signup(UserDto user);

    LoginResponseDto login(LoginRequestDto LoginRequestDto);

    void logout();
}
