package com.campuslands.proyectoSpringBoot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.campuslands.proyectoSpringBoot.repositories.entities.CuotaEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.SociosEntity;

public interface SociosRepository extends CrudRepository<SociosEntity,Long>{
/*     List<SociosEntity> findAllSocioByTipoCuota(CuotaEntity cuota); */
}
