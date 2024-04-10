package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.SociosConverte;
import com.campuslands.proyectoSpringBoot.Dto.SociosDTO;
import com.campuslands.proyectoSpringBoot.Services.SocioService;
import com.campuslands.proyectoSpringBoot.repositories.SociosRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.SociosEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SocioServiceImpl implements SocioService{
    @Autowired
    private SociosRepository sociosRepository;

    @Autowired
    private SociosConverte sociosConverte;

    @Override
    @Transactional(readOnly = true)
    public List<SociosDTO> findAll() {
        List<SociosEntity> socios = (List<SociosEntity>)sociosRepository.findAll();
        return socios.stream()
                     .map(socio -> sociosConverte.sociosDTO(socio))
                     .toList();
    }
    @Override
    @Transactional(readOnly = true)
    public SociosDTO findById(Long id) {
        Optional<SociosEntity> socioOptional = sociosRepository.findById(id);
        if (socioOptional.isPresent()) {
            SociosEntity sociosEntity = socioOptional.get();
            return sociosConverte.sociosDTO(sociosEntity);
        }
        return null;
    }
    @Override
    @Transactional
    public SociosDTO save(SociosDTO cuota) {
        SociosEntity socios = sociosConverte.converteSociosEntity(cuota);
        sociosRepository.save(socios);
        return sociosConverte.sociosDTO(socios);
    }
    @Override
    public void delete(Long id) {
        sociosRepository.deleteById(id);
    }
    @Override
    public SociosDTO update(Long id, SociosDTO cuota) {
        Optional<SociosEntity> socioCurrentOptional = sociosRepository.findById(id);
        if (socioCurrentOptional.isPresent()) {
            SociosEntity socioCurrent = sociosConverte.converteSociosEntity(cuota);
            socioCurrent.setId(id);
            socioCurrent.setIdDatosPersonales(socioCurrent.getIdDatosPersonales());
            socioCurrent.setCuentaBancaria(cuota.getCuentaBancaria());
            socioCurrent.setFechaPago(cuota.getFechaPago());
            socioCurrent.setId_cuota(socioCurrent.getId_cuota());

            sociosRepository.save(socioCurrent);

            return sociosConverte.sociosDTO(socioCurrent);
        }
        return null;
    }
/*     @Override
    public List<SociosDTO> findByIdCuota(Long idCuota) {
        List<SociosEntity> sociosEntities = sociosRepository.findByCuotaId(idCuota);
        return sociosConverte.sociosDTOList(sociosEntities);
    } */

}
