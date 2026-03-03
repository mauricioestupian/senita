package com.example.comoquiera.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.comoquiera.dtos.UsuarioDto;
import com.example.comoquiera.services.UsuarioServices;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    // servicio centralizado para operaciones CRUD sobre usuarios
    // Inyeccion de dependencias nativo sin @Autowired
    private final UsuarioServices usuarioServices;

    public UsuarioController(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioServices.getUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioServices.buscarporId(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioDto> createUsuario(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto saved = usuarioServices.saveUser(usuarioDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioServices.actualizarUsuario(id, usuarioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDto> deleteUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioServices.eliminarUsuario(id));
    }

}
