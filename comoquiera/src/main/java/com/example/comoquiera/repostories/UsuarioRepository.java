package com.example.comoquiera.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.comoquiera.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
