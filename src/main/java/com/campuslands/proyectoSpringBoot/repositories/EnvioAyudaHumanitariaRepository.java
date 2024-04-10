package com.campuslands.proyectoSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAyudaHumanitariaEntity;
@Repository
public interface EnvioAyudaHumanitariaRepository extends CrudRepository<EnvioAyudaHumanitariaEntity,Long> {

}
