package com.example.comoquiera.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UsuarioRol {

    @EmbeddedId
    private UsuarioRolId id;

    @ManyToOne
    @MapsId("userId")
    private Usuario usuario;

    @ManyToOne
    @MapsId("rolId")
    private Rol rol;

}
