
package com.isgb.projectjpa.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author isaias
 * Clase que representa uan entidad de subgeneros
 */
@Entity
@Table(name="subgenero")
public class SubGenero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSubGenero")
    private Long idSubGenero;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGenero")
    @Cascade(CascadeType.MERGE)
    private Genero genero;
    
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;
    
    @Column(name = "fechaModificacion")
    private LocalDateTime fechaModificacion;
    
    @Column(name = "estatus")
    private boolean estatus;

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
        
    public Long getIdSubGenero() {
        return idSubGenero;
    }

    public void setIdSubGenero(Long idSubGenero) {
        this.idSubGenero = idSubGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
}
