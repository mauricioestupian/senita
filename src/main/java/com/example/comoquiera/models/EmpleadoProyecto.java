package com.example.comoquiera.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EmpleadoProyecto {

    @EmbeddedId
    private EmpleadoProyectoId id = new EmpleadoProyectoId(null, null);

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("empleadoId")
    @JoinColumn(name = "empleado_id", foreignKey = @ForeignKey(name = "fk_empleado_proyecto_empleado"))
    private Empleado empleado;
    // @ForeignKey(name="fk_empleado_proyecto_empleado") es el nombre del constraint
    // de clave foránea que se creará en la base de datos para esta relación. Esto
    // ayuda a identificar claramente la relación entre las tablas y facilita la
    // gestión de la base de datos.

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("proyectoId")
    @JoinColumn(name = "proyecto_id", foreignKey = @ForeignKey(name = "fk_empleado_proyecto_proyecto"))
    private Proyecto proyecto;

    @Column(name = "Fecha_asignacion")
    private LocalDate fecAsig;

    @Size(max = 500)
    private String observaciones;

}
