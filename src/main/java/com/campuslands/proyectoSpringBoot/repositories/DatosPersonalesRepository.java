package com.campuslands.proyectoSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.DatosPersonalesEntity;
@Repository
public interface DatosPersonalesRepository extends CrudRepository<DatosPersonalesEntity,Long> {

}
