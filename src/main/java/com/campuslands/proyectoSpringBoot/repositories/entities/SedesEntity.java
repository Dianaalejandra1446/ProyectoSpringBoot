package com.campuslands.proyectoSpringBoot.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sedes")
@Data
public class SedesEntity {
    private Long id;
    private String nombre_sede;
    private String ciudad;
    private String domicilio;
    private String nombre_director;
}
