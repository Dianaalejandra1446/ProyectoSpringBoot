package com.campuslands.proyectoSpringBoot.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Envio_medicamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioMedicamentosEntity {
    @Column(name = "id_envio_medicamentos")
    private Long idEnvioMedicamentos;
    private String nombre_medicamento;
    @Column(name = "num_unidades")
    private Integer numUnidades;
}
