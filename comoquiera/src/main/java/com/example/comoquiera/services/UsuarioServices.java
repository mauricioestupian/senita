package com.example.comoquiera.services;

import java.util.List;

import com.example.comoquiera.dtos.UsuarioDto;

public interface UsuarioServices {

    public List<UsuarioDto> getUsuarios();

    public UsuarioDto saveUser(UsuarioDto usuarioDto);

    public UsuarioDto buscarporId(Long id);

    public UsuarioDto eliminarUsuario(Long id);

}
