package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.SedesDTO;

public interface SedeService {
    List<SedesDTO> findAll();

    SedesDTO findById(Long id);

    SedesDTO save(SedesDTO sedes);

    void delete(Long id);

    SedesDTO update(Long id,SedesDTO sedes);
}
