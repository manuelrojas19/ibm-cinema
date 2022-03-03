package com.ibm.academy.cinema.apirest.userservice.service.impl;

import com.ibm.academy.cinema.apirest.userservice.exception.NotFoundException;
import com.ibm.academy.cinema.apirest.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String NOT_FOUND_ERROR_MSG = "User was not found";

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(NOT_FOUND_ERROR_MSG));
    }
}
