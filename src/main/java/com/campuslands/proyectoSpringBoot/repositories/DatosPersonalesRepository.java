package com.campuslands.proyectoSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campuslands.proyectoSpringBoot.repositories.entities.DatosPersonalesEntity;

public interface DatosPersonalesRepository extends CrudRepository<DatosPersonalesEntity,Long> {

}
