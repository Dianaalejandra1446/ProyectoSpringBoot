package com.campuslands.proyectoSpringBoot.repositories.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTResponse {
    private String jwt;
}