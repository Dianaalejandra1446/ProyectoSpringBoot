package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.UsuarioDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.Usuario;

@Component
public class UsuarioConverte {
    @Autowired
    private ModelMapper dbm;

    public Usuario convertirDTOAUsuario(UsuarioDTO usuarioDTO){
        return dbm.map(usuarioDTO,Usuario.class);  
    }

    public UsuarioDTO convertirUsuarioADTO(Usuario usuario){
        UsuarioDTO usuarioDTO = dbm.map(usuario, UsuarioDTO.class);
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setCedula(usuario.getCedula());

        return usuarioDTO;
    }
}
