package com.campuslands.proyectoSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectoSpringBoot.repositories.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
