package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voluntarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoluntariadosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String profesion;
    @Column(nullable = false)
    private String disponiblidad;
    @Column(name = "numero_trabajos_participados")
    private Integer numeroTrabajosParticipados;
    // Agregar Relacion con sede
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Column(name = "id_datos_personales")
    List<DatosPersonalesEntity> idDatosPersonales;
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "id_sede")
    SedesEntity idsede;

}
