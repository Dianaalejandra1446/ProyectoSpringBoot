package com.campuslands.proyectoSpringBoot.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.VoluntariadosEntity;
@Repository
public interface VoluntariadosRepository extends CrudRepository<VoluntariadosEntity,Long>{
/*     // Encontrar voluntario por profesion
    List<VoluntariadosEntity> findAllVoluntariadoByProfesion(VoluntariadosEntity voluntariados);
    //  Encontrar voluntario por sede
    List<VoluntariadosEntity> findAllVoluntariadoBySede(VoluntariadosEntity voluntariados); */
}
