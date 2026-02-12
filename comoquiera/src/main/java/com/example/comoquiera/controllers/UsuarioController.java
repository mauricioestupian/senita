package com.example.comoquiera.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.comoquiera.models.Usuario;
import com.example.comoquiera.repostories.UsuarioRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UsuarioController {

    private final UsuarioRepository userepo;

    public UsuarioController(UsuarioRepository userepo){
        this.userepo = userepo;
    }

    @GetMapping("/")
    public String Inicio() {
        return new String("Inicio desde el controlador");
    }
    
    //Lee todos los datos
    @GetMapping("/user")
    public List<Usuario> ListUsers(){
        return userepo.findAll();
    }

    //Encontrar por ID
    @GetMapping("/{id}")
    public Usuario ObtenerUsuarioID(@PathVariable Long id) {
        return userepo.findById(id).orElseThrow(() -> new RuntimeException("No existe sa monda")) ;
    }
    
    @PostMapping("/crear")
    public Usuario CrearUsuario(@RequestBody Usuario usuario) {
        //TODO: process POST request
        return userepo.save(usuario);
    }
    
}

