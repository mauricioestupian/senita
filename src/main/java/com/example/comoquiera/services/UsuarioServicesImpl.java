package com.example.comoquiera.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.comoquiera.dtos.UsuarioDto;
import com.example.comoquiera.mapper.UsuarioMapper;
import com.example.comoquiera.models.Usuario;
import com.example.comoquiera.repostories.UsuarioRepository;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

    @Autowired
    private UsuarioRepository userepo;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDto> getUsuarios() {
        return usuarioMapper.toUsuariosDto(userepo.findAll());
    }

    @Override
    public UsuarioDto saveUser(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.toUsuario(usuarioDto);
        return usuarioMapper.toUsuarioDto(userepo.save(usuario));
    }

    @Override
    public UsuarioDto buscarporId(Long id) {
        Usuario usuario = userepo.findById(id).orElseThrow(() -> new RuntimeException("No existe usuario"));
        return usuarioMapper.toUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto eliminarUsuario(Long id) {
        Usuario usuario = userepo.findById(id).orElseThrow(() -> new RuntimeException("No existe usuario"));
        userepo.deleteById(id);
        return usuarioMapper.toUsuarioDto(usuario);
    }

}
