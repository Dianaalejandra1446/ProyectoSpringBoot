package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.SedeConverte;
import com.campuslands.proyectoSpringBoot.Dto.SedesDTO;
import com.campuslands.proyectoSpringBoot.Services.SedeService;
import com.campuslands.proyectoSpringBoot.repositories.SedesRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.SedesEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SedeServiceImpl implements SedeService{
    @Autowired
    private SedesRepository sedesRepository;
    @Autowired
    private SedeConverte sedeConvert;

    @Override
    @Transactional(readOnly = true)
    public List<SedesDTO> findAll() {
        List<SedesEntity> sede = (List<SedesEntity>) sedesRepository.findAll();
        return sede.stream()
                    .map(sedes -> sedeConvert.converteSedesDTO(sedes))
                    .toList();
    }
    @Override
    public SedesDTO findById(Long id) {
        Optional<SedesEntity> sedeOptional = sedesRepository.findById(id);
        if (sedeOptional.isPresent()) {
            SedesEntity sedesEntity = sedeOptional.get();
            return sedeConvert.converteSedesDTO(sedesEntity);
        }
        return null;
    }
    @Override
    @Transactional
    public SedesDTO save(SedesDTO sedes) {
        SedesEntity sede = sedeConvert.converteSedesEntity(sedes);
        sedesRepository.save(sede);
        return sedeConvert.converteSedesDTO(sede);
    }
    @Override
    public void delete(Long id) {
        sedesRepository.deleteById(id);
    }
    @Override
    public SedesDTO update(Long id, SedesDTO sedes) {
        Optional<SedesEntity> sedeCurrentOptional = sedesRepository.findById(id);
        if (sedeCurrentOptional.isPresent()) {
            SedesEntity sedeCurrent = sedeConvert.converteSedesEntity(sedes);
            sedeCurrent.setId(id);
            sedeCurrent.setNombre_sede(sedes.getNombre_sede());
            sedeCurrent.setCiudad(sedes.getCiudad());
            sedeCurrent.setDomicilio(sedes.getDomicilio());
            sedeCurrent.setNombre_director(sedes.getNombre_director());
            sedeCurrent.setId_socios(sedeCurrent.getId_socios());

            sedesRepository.save(sedeCurrent);
            return sedeConvert.converteSedesDTO(sedeCurrent);
        }
        return null;
    }
}
