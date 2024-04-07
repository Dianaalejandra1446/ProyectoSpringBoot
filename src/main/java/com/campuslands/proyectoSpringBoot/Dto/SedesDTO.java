package com.campuslands.proyectoSpringBoot.Dto;

import lombok.Data;

@Data
public class SedesDTO {
    private Long id;
    private String nombre_sede;
    private String ciudad;
    private String domicilio;
    private String nombre_director;
    private Long idSocio;
}
