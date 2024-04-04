package com.campuslands.proyectoSpringBoot.Dto;

import java.util.List;

import lombok.Data;

@Data
public class EnvioAyudaHumanitariaDTO {
    private Long idAyudaHumanitaria;
    private Integer numVoluntarios;
    private List<String> profesionVoluntarios;

}
