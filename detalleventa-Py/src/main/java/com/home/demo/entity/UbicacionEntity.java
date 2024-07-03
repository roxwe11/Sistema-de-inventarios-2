package com.home.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UbicacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUbicacion;
    private String nombreUbicacion;

    @OneToMany(mappedBy = "ubicacionEntity")
    @JsonIgnore
    private List<ProductoEntity> productoEntities;

    // Getters y setters...

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }

    public List<ProductoEntity> getProductoEntities() {
        return productoEntities;
    }

    public void setProductoEntities(List<ProductoEntity> productoEntities) {
        this.productoEntities = productoEntities;
    }
}
