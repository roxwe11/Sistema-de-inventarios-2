package com.home.demo.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    private Date fechaVenta;
    private Double totalVenta;
    
    @ManyToMany
    @JoinTable(
        name = "detalle_venta",
        joinColumns = @JoinColumn(name = "venta_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<ProductoEntity> productos;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Set<ProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoEntity> productos) {
        this.productos = productos;
    }

    public VentaEntity(int idVenta, Date fechaVenta, Double totalVenta, Set<ProductoEntity> productos) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.productos = productos;
    }

    public VentaEntity() {
    }

    public VentaEntity(Date fechaVenta, Double totalVenta) {
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }
}
