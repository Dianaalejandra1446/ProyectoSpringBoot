package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "socios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SociosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Column(name = "id_datos_personales")
    List<DatosPersonalesEntity> id_DatosPersonales;
    @Column(name = "cuenta_bancaria")
    private Double cuentaBancaria;
    @Column(name = "fecha_pago")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date FechaPago;
    @ManyToOne(targetEntity = CuotaEntity.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Column(name = "id_tipo_cuota")
    private List<CuotaEntity> id_cuota;
}
