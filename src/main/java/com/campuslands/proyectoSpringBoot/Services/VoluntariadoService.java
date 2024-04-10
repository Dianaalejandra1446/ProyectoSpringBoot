package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.VoluntariadosDTO;

public interface VoluntariadoService {
    List<VoluntariadosDTO> findAll();

    VoluntariadosDTO findById(Long id);

    VoluntariadosDTO save(VoluntariadosDTO voluntario);

    void delete(Long id);

    VoluntariadosDTO update(Long id,VoluntariadosDTO voluntario); 

/*     List<VoluntariadosDTO> findAllVoluntariadoByProfesion(VoluntariadosDTO voluntariados);

    List<VoluntariadosDTO> findAllVoluntariadoBySede(VoluntariadosDTO voluntariados); */
}
