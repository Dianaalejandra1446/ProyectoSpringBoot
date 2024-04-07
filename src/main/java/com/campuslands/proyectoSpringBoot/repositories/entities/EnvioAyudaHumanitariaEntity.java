package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Envio_ayuda_humanitaria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioAyudaHumanitariaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ayuda_humanitaria")
    private Long idAyudaHumanitaria;

    @Column(name = "num_voluntarios")
    private Integer numVoluntarios;

    @OneToMany(targetEntity = VoluntariadosEntity.class, cascade = CascadeType.ALL)
    @Column(name = "id_voluntarios")
    List<VoluntariadosEntity> idVoluntariados;

    @ManyToOne(targetEntity = EnvioSedesEntity.class , cascade = CascadeType.ALL)
    @Column(name = "id_envio_sede")
    private EnvioSedesEntity idEnvioSedesEntity;
}
