package com.campuslands.proyectoSpringBoot.repositories.entities;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private Long cedula;

    private String email;

    @Column(name = "pwd")
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Column(name="fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;    
}
