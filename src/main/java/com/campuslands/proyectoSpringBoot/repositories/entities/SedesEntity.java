package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(cascade = CascadeType.ALL)
    private List<SociosEntity> lista_socios;
}
