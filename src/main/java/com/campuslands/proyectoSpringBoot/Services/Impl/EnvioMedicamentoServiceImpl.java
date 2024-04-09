package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.EnvioMedicamentoConverte;
import com.campuslands.proyectoSpringBoot.Dto.EnvioMedicamentoDTO;
import com.campuslands.proyectoSpringBoot.Services.EnvioMedicamentosService;
import com.campuslands.proyectoSpringBoot.repositories.EnvioMedicamentosRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioMedicamentosEntity;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EnvioMedicamentoServiceImpl implements EnvioMedicamentosService{

    @Autowired
    private EnvioMedicamentosRepository envioMedicamentosRepository;
    @Autowired
    private EnvioMedicamentoConverte envioMedicamentoConvert;


@Override
@Transactional(readOnly = true)
public EnvioMedicamentoDTO findById(Long id) {
    Optional<EnvioMedicamentosEntity> envioOptional = envioMedicamentosRepository.findById(id);
    if (envioOptional.isPresent()) {
        EnvioMedicamentosEntity envioMedicamentosEntity = envioOptional.get();
        return envioMedicamentoConvert.converteEnvioMedicamentoDTO(envioMedicamentosEntity);
    }
    return null;
}
@Override
@Transactional
public EnvioMedicamentoDTO save(EnvioMedicamentoDTO envioMedicamento) {
    EnvioMedicamentosEntity envio = envioMedicamentoConvert.converteEnvioMedicamentosEntity(envioMedicamento);
    envioMedicamentosRepository.save(envio);
    return envioMedicamentoConvert.converteEnvioMedicamentoDTO(envio);
}
@Override
public void delete(Long id) {
    envioMedicamentosRepository.deleteById(id);
}
@Override
public EnvioMedicamentoDTO update(Long id, EnvioMedicamentoDTO envioMedicamento) {
    Optional<EnvioMedicamentosEntity> envioCurrentOptional = envioMedicamentosRepository.findById(id);
    if (envioCurrentOptional.isPresent()) {
        EnvioMedicamentosEntity envioCurrent = envioMedicamentoConvert.converteEnvioMedicamentosEntity(envioMedicamento);
        envioCurrent.setIdEnvioMedicamentos(id);
        envioCurrent.setNombre_medicamento(envioMedicamento.getNombreMedicamento());
        envioCurrent.setNumUnidades(envioMedicamento.getNumUnidades());

        envioMedicamentosRepository.save(envioCurrent);

        return envioMedicamentoConvert.converteEnvioMedicamentoDTO(envioCurrent);
    }
    return null;
}


}