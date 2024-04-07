package com.campuslands.proyectoSpringBoot.Dto;

import lombok.Data;

@Data
public class DatosPersonalesDTO {
    private Long idDatos;
    private String nombre;
    private String apellido;
    private Double documento;
    private Integer telefono;
    private String email;
}
