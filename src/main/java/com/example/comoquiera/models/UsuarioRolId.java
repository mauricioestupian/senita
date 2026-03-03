package com.example.comoquiera.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data
@AllArgsConstructor
public class UsuarioRolId implements Serializable {
    private Long userId;
    private Long rolId;

}
