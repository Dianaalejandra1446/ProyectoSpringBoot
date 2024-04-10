package com.campuslands.proyectoSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectoSpringBoot.repositories.entities.SociosEntity;
@Repository
public interface SociosRepository extends JpaRepository<SociosEntity, Long> {
/*      @Query("SELECT s FROM SociosEntity s WHERE s.idCuota = :idCuota")
    List<SociosEntity> findByCuotaId(@Param("idCuota") Long idCuota);  */
    
}

