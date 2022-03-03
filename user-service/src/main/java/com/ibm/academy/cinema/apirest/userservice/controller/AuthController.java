package com.ibm.academy.cinema.apirest.userservice.controller;

import com.ibm.academy.cinema.apirest.userservice.dto.AdminDto;
import com.ibm.academy.cinema.apirest.userservice.dto.LoginRequestDto;
import com.ibm.academy.cinema.apirest.userservice.dto.SubscriberDto;
import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;
import com.ibm.academy.cinema.apirest.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Endpoint que realiza el login de un usuario en el sistema
     * @param request Objeto con las credenciales del usuario.
     * @return ResponseEntity con el status de la solicitud.
     */
    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

    /**
     * Endpoint que permite a un usuario registrarse en la aplicación como subscriptor.
     * @param subscriber datos del usuario a registrarse.
     * @return ResponseEntity con el status de la solicitud.
     */
    @PostMapping("/signup")
    public ResponseEntity<?> subscriberSignup(@Valid @RequestBody SubscriberDto subscriber) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(subscriber));
    }

}
