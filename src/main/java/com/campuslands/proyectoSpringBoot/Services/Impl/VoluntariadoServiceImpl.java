package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.VoluntariadoConverte;
import com.campuslands.proyectoSpringBoot.Dto.VoluntariadosDTO;
import com.campuslands.proyectoSpringBoot.Services.VoluntariadoService;
import com.campuslands.proyectoSpringBoot.repositories.VoluntariadosRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.VoluntariadosEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoluntariadoServiceImpl implements VoluntariadoService {
    @Autowired
    private VoluntariadosRepository voluntariadosRepository;
    @Autowired
    private VoluntariadoConverte voluntariadoConverte;

    @Override
    @Transactional(readOnly = true)
    public List<VoluntariadosDTO> findAll() {
        List<VoluntariadosEntity> voluntariados = (List<VoluntariadosEntity>) voluntariadosRepository.findAll();
        return voluntariados.stream()
                            .map(voluntario -> voluntariadoConverte.voluntariadosDTO(voluntario))
                            .toList();
    }
    @Override
    @Transactional(readOnly = true)
    public VoluntariadosDTO findById(Long id) {
        Optional<VoluntariadosEntity> voluntariadosOptional = voluntariadosRepository.findById(id);
        if (voluntariadosOptional.isPresent()) {
            VoluntariadosEntity voluntariadosEntity = voluntariadosOptional.get();
            return voluntariadoConverte.voluntariadosDTO(voluntariadosEntity);
        }
        return null;
    }
    @Override
    public VoluntariadosDTO save(VoluntariadosDTO voluntario) {
        VoluntariadosEntity voluntarios = voluntariadoConverte.voluntariadosEntityconvertDTO(voluntario);
        voluntariadosRepository.save(voluntarios);
        return voluntariadoConverte.voluntariadosDTO(voluntarios);
    }

    @Override
    public void delete(Long id) {
        voluntariadosRepository.deleteById(id);
    }
    @Override
    public VoluntariadosDTO update(Long id, VoluntariadosDTO voluntario) {
        Optional<VoluntariadosEntity> voluntarioadosCurrentOptional = voluntariadosRepository.findById(id);
        if (voluntarioadosCurrentOptional.isPresent()) {
            VoluntariadosEntity voluntarioCurrent = voluntariadoConverte.voluntariadosEntityconvertDTO(voluntario);
            voluntarioCurrent.setId_voluntariado(id);
            voluntarioCurrent.setTipo(voluntario.getTipo());
            voluntarioCurrent.setProfesion(voluntario.getProfesion());
            voluntarioCurrent.setDisponibilidad(voluntario.getDisponiblidad());
            voluntarioCurrent.setNumeroTrabajosParticipados(voluntario.getNumeroTrabajosParticipados());
            voluntarioCurrent.setDatosPersonales(voluntarioCurrent.getDatosPersonales());
            voluntarioCurrent.setId_sede(voluntarioCurrent.getId_sede());

            voluntariadosRepository.save(voluntarioCurrent);

            return voluntariadoConverte.voluntariadosDTO(voluntarioCurrent);
        }
        return null;
    }
}
