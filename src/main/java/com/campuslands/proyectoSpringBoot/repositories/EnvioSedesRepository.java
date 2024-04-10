package com.campuslands.proyectoSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioSedesEntity;
@Repository
public interface EnvioSedesRepository extends CrudRepository<EnvioSedesEntity,Long>{

}
