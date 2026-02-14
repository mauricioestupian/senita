package com.example.comoquiera.mapper;

import java.util.List;

import com.example.comoquiera.dtos.UsuarioDto;
import com.example.comoquiera.models.Usuario;

public interface UsuarioMapper {

    Usuario toUsuario(UsuarioDto usuarioDto);

    UsuarioDto toUsuarioDto(Usuario usuario);

    List<UsuarioDto> toUsuariosDto(List<Usuario> usuarios);

}
