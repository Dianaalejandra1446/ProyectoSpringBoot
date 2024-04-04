package com.campuslands.proyectoSpringBoot.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Table(name = "datos_personales")
@Data
public class DatosPersonalesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_datos")
    private Long idDatos;
    private String nombre;
    private String apellido;
    private Double documento;
    private String varchar;
    private Integer telefono;
    @Email(message = "No cumple con el formato de la cuenta de correo")
    @Column(nullable = false,unique = true)
    private String email;
}
