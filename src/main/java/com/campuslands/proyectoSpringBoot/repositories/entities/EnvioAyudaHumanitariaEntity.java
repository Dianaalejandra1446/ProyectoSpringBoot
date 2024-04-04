package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Envio_ayuda_humanitaria")
@Data
public class EnvioAyudaHumanitariaEntity {
    @Column(name = "id_ayuda_humanitaria")
    private Long idAyudaHumanitaria;
    @Column(name = "num_voluntarios")
    private Integer numVoluntarios;
    @ManyToOne(targetEntity = VoluntariadosEntity.class, cascade = CascadeType.ALL)
    @Column(name = "id_voluntarios")
    List<VoluntariadosEntity> idVoluntariados;
    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "id_sedes")
    List<SedesEntity> idSedes;
    //
    @Column(name = "id_envio")
    List<EnvioEntity> idEnvio;
}
