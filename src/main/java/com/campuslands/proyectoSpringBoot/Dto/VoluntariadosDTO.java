package com.campuslands.proyectoSpringBoot.Dto;

import lombok.Data;

@Data
public class VoluntariadosDTO {
    private Long idVoluntariados;
    private String tipo;
    private String profesion;
    private String disponiblidad;
    private Integer numeroTrabajosParticipados;
    private DatosPersonalesDTO datosPersonales;
    private String sedeInscrita;
}
