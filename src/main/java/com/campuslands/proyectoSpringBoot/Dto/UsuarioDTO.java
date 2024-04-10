package com.campuslands.proyectoSpringBoot.Dto;

import java.util.List;

import com.campuslands.proyectoSpringBoot.repositories.entities.Role;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;
    @NotNull(message = "no puede estar vacio")
    private Long cedula;
    private String email;
    private List<Role> roles;
    
}