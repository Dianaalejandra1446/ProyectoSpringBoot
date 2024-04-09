package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campuslands.proyectoSpringBoot.Configuracion.DatosPersonalesConverte;
import com.campuslands.proyectoSpringBoot.Dto.DatosPersonalesDTO;
import com.campuslands.proyectoSpringBoot.Services.DatosPersonalesService;
import com.campuslands.proyectoSpringBoot.repositories.DatosPersonalesRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.DatosPersonalesEntity;

import lombok.AllArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
@Service
@AllArgsConstructor
public class DatosPersonaleServiceImpl implements DatosPersonalesService{
    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;

    @Autowired
    private DatosPersonalesConverte datosPersonalesConvert;

    @Override
    @Transactional(readOnly = true)
    public List<DatosPersonalesDTO> findAll() {
        List<DatosPersonalesEntity> datosPersonales = (List<DatosPersonalesEntity>) datosPersonalesRepository.findAll();
        return datosPersonales.stream()
                              .map(datosPersonal -> datosPersonalesConvert.convertiPersonalesDTO(datosPersonal))
                              .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DatosPersonalesDTO findById(Long id) {
        Optional<DatosPersonalesEntity> datosOptional = datosPersonalesRepository.findById(id);
        if (datosOptional.isPresent()) {
            DatosPersonalesEntity datosPersonalesEntity = datosOptional.get();
            return datosPersonalesConvert.convertiPersonalesDTO(datosPersonalesEntity);
        }
        return null;
    }

    @Override
    @Transactional
    public DatosPersonalesDTO save(DatosPersonalesDTO datosPersonales) {
        DatosPersonalesEntity datos = datosPersonalesConvert.converDatosPersonalesEntity(datosPersonales);
        datosPersonalesRepository.save(datos);
        return datosPersonalesConvert.convertiPersonalesDTO(datos);
    }

    @Override
    public void delete(Long id) {
        datosPersonalesRepository.deleteById(id);
    }

    @Override
    public DatosPersonalesDTO update(Long id, DatosPersonalesDTO datosPersonales) {
        Optional<DatosPersonalesEntity> datosCurrentOptional = datosPersonalesRepository.findById(id);
        if (datosCurrentOptional.isPresent()) {
            DatosPersonalesEntity datosCurrent = datosPersonalesConvert.converDatosPersonalesEntity(datosPersonales);
            datosCurrent.setIdDatos(id);
            datosCurrent.setNombre(datosPersonales.getNombre());
            datosCurrent.setApellido(datosPersonales.getApellido());
            datosCurrent.setDocumento(datosPersonales.getDocumento());
            datosCurrent.setTelefono(datosPersonales.getTelefono());
            datosCurrent.setEmail(datosPersonales.getEmail());

            datosPersonalesRepository.save(datosCurrent);

            return datosPersonalesConvert.convertiPersonalesDTO(datosCurrent);
        }
        return null;
    }
    
}
