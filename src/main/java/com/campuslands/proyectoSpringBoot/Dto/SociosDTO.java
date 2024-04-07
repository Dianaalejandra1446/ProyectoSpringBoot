package com.campuslands.proyectoSpringBoot.Dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class SociosDTO {
    private Long idSocio;
    List<DatosPersonalesDTO> datosPersonales;
    private Double cuentaBancaria;
    private Date FechaPago;
    private List<CuotaDTO> datosCuota; 
}
