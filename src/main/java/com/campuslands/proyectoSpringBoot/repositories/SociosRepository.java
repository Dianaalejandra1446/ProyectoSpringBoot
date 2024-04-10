package com.campuslands.proyectoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.SociosEntity;
@Repository
public interface SociosRepository extends JpaRepository<SociosEntity, Long> {
/*      @Query("SELECT s FROM SociosEntity s WHERE s.idCuota = :idCuota")
    List<SociosEntity> findByCuotaId(@Param("idCuota") Long idCuota);  */
    
}

