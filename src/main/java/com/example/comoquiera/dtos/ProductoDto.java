package com.example.comoquiera.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductoDto {
    private Long id_producto;
    private String nombre_producto;
    private Integer precio_producto;
    private String descripcion;
    private Integer cantidad;

}
