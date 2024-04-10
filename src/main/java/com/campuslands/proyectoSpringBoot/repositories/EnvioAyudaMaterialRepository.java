package com.campuslands.proyectoSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAyudaMaterialEntity;
@Repository
public interface EnvioAyudaMaterialRepository extends CrudRepository<EnvioAyudaMaterialEntity,Long>{

}
