package com.example.comoquiera.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data  //hashcode
@AllArgsConstructor
public class EmpleadoProyectoId implements Serializable{

    private Long empleadoId;
    private Long proyectoId;

}
