package com.example.comoquiera.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Productos")
@Entity

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(nullable = false, length = 50)
    private String nom_prod;
    @Column(nullable = false, length = 50)
    private Integer precio_prod;
    @Column(nullable = false, length = 50)
    private String descrip_prod;
    @Column(nullable = false, length = 50)
    private Integer cantidad_prod;
}
