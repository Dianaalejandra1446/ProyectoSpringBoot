package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.Date;

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
@Table(name = "Envio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private Long idEnvio;
    @Column(name = "codigo_envio" )
    private Double codigoEnvio;
    @Column(name = "nombre_refugio")
    private String nombreRefugio;
    private String destino;
    
    @Column(name = "fecha_salida")
    private Date fechaSalida;
}
