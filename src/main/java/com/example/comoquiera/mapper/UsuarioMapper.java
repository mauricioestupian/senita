package com.example.comoquiera.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.comoquiera.dtos.UsuarioDto;
import com.example.comoquiera.models.Usuario;
@Component

public interface UsuarioMapper {

    Usuario toUsuario(UsuarioDto usuarioDto);

    UsuarioDto toUsuarioDto(Usuario usuario);

    List<UsuarioDto> toUsuariosDto(List<Usuario> usuarios);

    void updateusuario(Usuario usuario, UsuarioDto usuarioDto);

}
