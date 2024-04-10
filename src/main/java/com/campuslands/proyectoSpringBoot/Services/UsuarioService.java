package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.UsuarioDTO;

public interface UsuarioService {
    
    List<UsuarioDTO> findAll();    

    public UsuarioDTO save(UsuarioDTO usuarioDTO);

    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO);

    void deleteById(Long id);

}
