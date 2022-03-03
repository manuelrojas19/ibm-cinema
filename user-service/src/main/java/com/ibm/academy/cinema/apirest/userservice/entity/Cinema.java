package com.ibm.academy.cinema.apirest.userservice.entity;

import com.ibm.academy.cinema.apirest.userservice.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cinema extends User {

    @NotBlank
    @Size(max = 200)
    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String web;

    @NotBlank
    @Size(max = 200)
    @Column(columnDefinition = "TEXT", nullable = false, unique = true)
    private String address;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(Roles.CINEMA.name()));
    }
}
