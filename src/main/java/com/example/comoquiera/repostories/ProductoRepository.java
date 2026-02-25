package com.example.comoquiera.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.comoquiera.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
