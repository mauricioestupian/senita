package com.example.comoquiera.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.comoquiera.dtos.UsuarioDto;
import com.example.comoquiera.models.Usuario;

@Component
public class UsuarioMapperImplement implements UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioDto usuarioDto) {

        if (usuarioDto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId_usuario());
        usuario.setNom(usuarioDto.getNombre());
        usuario.setApe(usuarioDto.getApellido());
        usuario.setEmail(usuarioDto.getCorreo());
        return usuario;
    }

    @Override
    public UsuarioDto toUsuarioDto(Usuario usuario) {

        if (usuario == null) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId_usuario(usuario.getId());
        usuarioDto.setNombre(usuario.getNom());
        usuarioDto.setApellido(usuario.getApe());
        usuarioDto.setCorreo(usuario.getEmail());
        return usuarioDto;

    }

    @Override
    public List<UsuarioDto> toUsuariosDto(List<Usuario> usuarios) {

        if (usuarios == null) {
            return null;
        }

        List<UsuarioDto> usuariosDto = new ArrayList<UsuarioDto>(usuarios.size());
        for (Usuario usuario : usuarios) {
            usuariosDto.add(toUsuarioDto(usuario));
        }
        return usuariosDto;
    }

}