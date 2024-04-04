package com.campuslands.proyectoSpringBoot.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Envios_sedes")
@Data
public class EnvioSedesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio_sedes")
    private Long idEnvioSedes;
    @Column(name = "id_envio")
    private EnvioEntity idEnvio;
    @Column(name = "id_sede")
    private SedesEntity idSede;
}