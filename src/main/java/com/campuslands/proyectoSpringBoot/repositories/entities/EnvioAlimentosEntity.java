package com.campuslands.proyectoSpringBoot.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Envio_alimentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioAlimentosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio_alimentos")
    private Long idEnvioAlimentos;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "num_toneladas")
    private Double numToneladas;
}
