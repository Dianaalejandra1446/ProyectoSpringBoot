package com.campuslands.proyectoSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioMedicamentosEntity;
@Repository
public interface EnvioMedicamentosRepository extends CrudRepository<EnvioMedicamentosEntity,Long>{

}
