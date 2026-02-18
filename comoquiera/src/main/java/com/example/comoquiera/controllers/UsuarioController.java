package com.example.comoquiera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.comoquiera.dtos.UsuarioDto;
import com.example.comoquiera.models.Usuario;
import com.example.comoquiera.repostories.UsuarioRepository;
import com.example.comoquiera.services.UsuarioServices;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository userepo;

    public UsuarioController(UsuarioRepository userepo) {
        this.userepo = userepo;
    }

    @GetMapping("/")
    public String Inicio() {
        return new String("Inicio desde el controlador");
    }

    // Lee todos los datos
    @GetMapping("/users")
    public List<Usuario> ListUsers() {
        return userepo.findAll();
    }

    // Encontrar por ID
    @GetMapping("/{id}")
    public Usuario ObtenerUsuarioID(@PathVariable Long id) {
        return userepo.findById(id).orElseThrow(() -> new RuntimeException("No existe sa monda"));
    }

    @PostMapping("/crear")
    public Usuario CrearUsuario(@RequestBody Usuario usuario) {
        // TODO: process POST request
        return userepo.save(usuario);
    }

    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDto>> todosusuarios() {
        return new ResponseEntity<>(usuarioServices.getUsuarios(), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<UsuarioDto> guardarusuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuarioServices.saveUser(usuarioDto), HttpStatus.CREATED);
    }
}
