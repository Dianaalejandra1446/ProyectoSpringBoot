package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "id_datos_personales")
    private DatosPersonalesEntity idDatosPersonales;

    @Column(name = "cuenta_bancaria")
    private Double cuentaBancaria;

    @Column(name = "fecha_pago")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date FechaPago;

    @ManyToOne
    private CuotaEntity id_cuota;
}
