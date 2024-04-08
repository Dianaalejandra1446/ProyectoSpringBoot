package com.campuslands.proyectoSpringBoot.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    private Long id_voluntariado; 

    private String tipo;
    private String profesion;

    @Column(nullable = false, name = "disponibilidad")
    private String disponibilidad;

    @Column(name = "numero_trabajos_participados")
    private Integer numeroTrabajosParticipados;

    @OneToOne
    @JoinColumn(name = "id_datos_personales")
    private DatosPersonalesEntity datosPersonales;

    @ManyToOne 
    private SedesEntity id_sede;
}
