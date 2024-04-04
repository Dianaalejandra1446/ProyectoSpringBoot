package com.campuslands.proyectoSpringBoot.Dto;

import java.util.List;

import lombok.Data;

@Data
public class VoluntariadosDTO {
    private Long id;
    private String tipo;
    private String profesion;
    private String disponiblidad;
    private Integer numeroTrabajosParticipados;
    List<DatosPersonalesDTO> datosPersonales;
    private Long idSede;
}
