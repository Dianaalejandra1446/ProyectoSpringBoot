package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class EnvioAyudaMaterialEntity {
    private Long id_ayuda_material;
    @ManyToOne(targetEntity = EnvioSedesEntity.class,cascade = CascadeType.ALL)
    @Column(name = "id_envio_sede")
    private List<EnvioSedesEntity>idEnvioSedes;
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "id_envio_alimentos")
    private List<EnvioAlimentosEntity> idEnvioAlimentos;
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "id_envio_medicamentos")
    private List<EnvioMedicamentosEntity> idEnvioMedicamentos;
}
