package com.campuslands.proyectoSpringBoot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.campuslands.proyectoSpringBoot.repositories.entities.VoluntariadosEntity;

public interface VoluntariadosRepository extends CrudRepository<VoluntariadosEntity,Long>{
/*     // Encontrar voluntario por profesion
    List<VoluntariadosEntity> findAllVoluntariadoByProfesion(VoluntariadosEntity voluntariados);
    //  Encontrar voluntario por sede
    List<VoluntariadosEntity> findAllVoluntariadoBySede(VoluntariadosEntity voluntariados); */
}
