package com.ibm.academy.cinema.apirest.userservice.service.impl;

import com.ibm.academy.cinema.apirest.userservice.dto.LoginRequestDto;
import com.ibm.academy.cinema.apirest.userservice.dto.LoginResponseDto;
import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;
import com.ibm.academy.cinema.apirest.userservice.entity.User;
import com.ibm.academy.cinema.apirest.userservice.mapper.UserMapper;
import com.ibm.academy.cinema.apirest.userservice.repository.UserRepository;
import com.ibm.academy.cinema.apirest.userservice.service.AuthService;
import com.ibm.academy.cinema.apirest.userservice.util.JwtTokenUtil;
import com.ibm.academy.cinema.apirest.userservice.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto signup(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        if (userRepository.existsByUsername(user.getEmail()) || userRepository.existsByUsername(user.getUsername()))
            throw new RuntimeException("Conflict");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(requestDto.getUsername(),
                        requestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByUsername(requestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Token newAccessToken = jwtTokenUtil.generateAccessToken(user);
        return LoginResponseDto.builder()
                .status("Successful")
                .message("User is login in")
                .token(newAccessToken.getTokenValue())
                .build();
    }

    @Override
    public void logout() {

    }
}
