package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Envio")
public class EnvioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_envio;
    private Double codigo_envio;
    private String nombre_refugio;
    private String destino;
    private Date fecha_salida;
}
