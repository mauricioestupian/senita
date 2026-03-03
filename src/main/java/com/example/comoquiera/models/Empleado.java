package com.example.comoquiera.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String ape;

    @Column
    private String tel;

    // Un empleado tiene un cargo, es decir, pertenece a un cargo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id", nullable = false, foreignKey = @ForeignKey(name = "Fk_Empleado_cargo"))
    private Cargo cargo;

    // un Empleado puede estar en varios proyectos es decir tener muchas
    // asignaciones
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<EmpleadoProyecto> asignaciones = new ArrayList<>();

    // agregar campos usuario y contraseña para login
    @Column(nullable = false, unique = true, length = 250)
    private String username;

    @Column(nullable = false, length = 250)
    private String password;

    // nullable = false: indica que la columna NO puede contener valores nulos en
    // la base de datos.

    // unique = true: le dice a JPA/Hibernate que esa columna debe tener un índice
    // único en la base de datos.

}
