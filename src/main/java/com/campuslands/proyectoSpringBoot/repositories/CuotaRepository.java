package com.campuslands.proyectoSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.CuotaEntity;
@Repository
public interface CuotaRepository extends CrudRepository<CuotaEntity,Long> {

}
