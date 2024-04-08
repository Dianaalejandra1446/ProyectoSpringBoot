package com.campuslands.proyectoSpringBoot.Dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SociosDTO {
    private Long idSocio;
    private DatosPersonalesDTO datosPersonales;
    @NotEmpty(message = "no puede estar vacio")
    private Double cuentaBancaria;
    private Date FechaPago;
    private String tipoCuota; 
}
