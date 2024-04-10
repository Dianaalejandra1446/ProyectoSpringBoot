package com.campuslands.proyectoSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAlimentosEntity;
@Repository
public interface EnvioAlimentosRepository extends CrudRepository<EnvioAlimentosEntity,Long>{

}
