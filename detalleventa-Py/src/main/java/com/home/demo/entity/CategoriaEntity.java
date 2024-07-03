package com.home.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;
    private String nombreCategoria;
    private String detalleCategoria;
    
    @OneToMany(mappedBy = "categoriaEntity")
    @JsonIgnore
    private List<ProductoEntity> productoEntities;

    // Getters y setters...

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDetalleCategoria() {
        return detalleCategoria;
    }

    public void setDetalleCategoria(String detalleCategoria) {
        this.detalleCategoria = detalleCategoria;
    }

    public List<ProductoEntity> getProductoEntities() {
        return productoEntities;
    }

    public void setProductoEntities(List<ProductoEntity> productoEntities) {
        this.productoEntities = productoEntities;
    }

    public CategoriaEntity(int idCategoria, String nombreCategoria, String detalleCategoria,
                           List<ProductoEntity> productoEntities) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.detalleCategoria = detalleCategoria;
        this.productoEntities = productoEntities;
    }

    public CategoriaEntity() {
    }
}
