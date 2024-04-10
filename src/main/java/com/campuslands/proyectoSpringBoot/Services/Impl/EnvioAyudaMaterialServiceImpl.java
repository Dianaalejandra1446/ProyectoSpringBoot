package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.EnvioAlimentosConverte;
import com.campuslands.proyectoSpringBoot.Configuracion.EnvioAyudaMaterialConverte;
import com.campuslands.proyectoSpringBoot.Configuracion.EnvioMedicamentoConverte;
import com.campuslands.proyectoSpringBoot.Configuracion.EnvioSedesConverte;
import com.campuslands.proyectoSpringBoot.Dto.EnvioAlimentosDTO;
import com.campuslands.proyectoSpringBoot.Dto.EnvioAyudaMaterialDTO;
import com.campuslands.proyectoSpringBoot.Dto.EnvioMedicamentoDTO;
import com.campuslands.proyectoSpringBoot.Dto.EnvioSedesDTO;
import com.campuslands.proyectoSpringBoot.Services.EnvioAyudaMaterialService;
import com.campuslands.proyectoSpringBoot.repositories.EnvioAyudaMaterialRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAlimentosEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAyudaMaterialEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioMedicamentosEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioSedesEntity;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EnvioAyudaMaterialServiceImpl implements EnvioAyudaMaterialService{
    @Autowired
    private EnvioAyudaMaterialRepository envioAyudaMaterialRepository;
    @Autowired
    private EnvioAyudaMaterialConverte envioAyudaMaterialConverte;
    @Autowired
    private EnvioSedesConverte envioSedesConverte;
    @Autowired
    private EnvioAlimentosConverte envioAlimentosConverte;
    @Autowired
    private EnvioMedicamentoConverte envioMedicamentoConverte;

    @Override
    @Transactional(readOnly = true)
    public List<EnvioAyudaMaterialDTO> findAll() {
        Iterable<EnvioAyudaMaterialEntity> envios = envioAyudaMaterialRepository.findAll();
        return StreamSupport.stream(envios.spliterator(), false)
                .map(envioAyudaMaterialConverte::convertirEntityADTO)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public EnvioAyudaMaterialDTO findById(Long id) {
        Optional<EnvioAyudaMaterialEntity> envioOptional = envioAyudaMaterialRepository.findById(id);
        if (envioOptional.isPresent()) {
            EnvioAyudaMaterialEntity envioAyudaMaterialEntity = envioOptional.get();
            return envioAyudaMaterialConverte.convertirEntityADTO(envioAyudaMaterialEntity);
        }
        return null;
    }

    @Override
    @Transactional
    public EnvioAyudaMaterialDTO save(EnvioAyudaMaterialDTO envioAyudaMaterial) {
        EnvioAyudaMaterialEntity envio = envioAyudaMaterialConverte.convertirDTOAEntity(envioAyudaMaterial);
        envioAyudaMaterialRepository.save(envio);
        return envioAyudaMaterialConverte.convertirEntityADTO(envio);
    }

    @Override
    public void delete(Long id) {
        envioAyudaMaterialRepository.deleteById(id);
    }

    @Override
    public EnvioAyudaMaterialDTO update(Long id, EnvioAyudaMaterialDTO envioAyudaMaterial) {
        Optional<EnvioAyudaMaterialEntity> envioCurrentOptional = envioAyudaMaterialRepository.findById(id);
        if (envioCurrentOptional.isPresent()) {
            EnvioAyudaMaterialEntity envioCurrent = envioCurrentOptional.get();
            envioCurrent.setId_ayuda_material(id);
            
            // Actualizar la lista de envío de sedes
            envioCurrent.getIdEnvioSedes().clear(); // Limpiar la lista existente
            for (EnvioSedesDTO envioSedeDTO : envioAyudaMaterial.getEnvioSedes()) {
                EnvioSedesEntity envioSedesEntity = envioSedesConverte.converterSedesEntity(envioSedeDTO);
                envioCurrent.getIdEnvioSedes().add(envioSedesEntity);
            }
            
            // Actualizar la lista de envío de alimentos
            envioCurrent.getIdEnvioAlimentos().clear();
            for (EnvioAlimentosDTO envioAlimentoDTO : envioAyudaMaterial.getEnvioAlimentos()) {
                EnvioAlimentosEntity envioAlimentosEntity = envioAlimentosConverte.convertirDTOAlimentosEntity(envioAlimentoDTO);
                envioCurrent.getIdEnvioAlimentos().add(envioAlimentosEntity);
            }
            
            // Actualizar la lista de envío de medicamentos
            envioCurrent.getIdEnvioMedicamentos().clear(); 
            for (EnvioMedicamentoDTO envioMedicamentoDTO : envioAyudaMaterial.getEnvioMedicamentos()) {
                EnvioMedicamentosEntity envioMedicamentosEntity = envioMedicamentoConverte.converteEnvioMedicamentosEntity(envioMedicamentoDTO);
                envioCurrent.getIdEnvioMedicamentos().add(envioMedicamentosEntity);
            }
            
            envioAyudaMaterialRepository.save(envioCurrent);
            return envioAyudaMaterialConverte.convertirEntityADTO(envioCurrent);
        }
        return null;
    }
    
    
}
