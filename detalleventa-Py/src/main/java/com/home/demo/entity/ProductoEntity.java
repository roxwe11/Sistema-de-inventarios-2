package com.home.demo.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String nombreProducto;
    private Double precioCompra;
    private Double precioVenta;
    private int stock;
    private Date fechaVencimiento;

    @ManyToMany(mappedBy = "productos")
    private Set<VentaEntity> ventas;

    @ManyToOne
    private CategoriaEntity categoriaEntity;

    @ManyToOne
    private TipoEntity tipoEntity;

    @ManyToOne
    private UbicacionEntity ubicacionEntity;

    // Getters y setters...

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Set<VentaEntity> getVentas() {
        return ventas;
    }

    public void setVentas(Set<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    public CategoriaEntity getCategoriaEntity() {
        return categoriaEntity;
    }

    public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
        this.categoriaEntity = categoriaEntity;
    }

    public TipoEntity getTipoEntity() {
        return tipoEntity;
    }

    public void setTipoEntity(TipoEntity tipoEntity) {
        this.tipoEntity = tipoEntity;
    }

    public UbicacionEntity getUbicacionEntity() {
        return ubicacionEntity;
    }

    public void setUbicacionEntity(UbicacionEntity ubicacionEntity) {
        this.ubicacionEntity = ubicacionEntity;
    }

    // Constructor...

    public ProductoEntity(int idProducto, String nombreProducto, Double precioCompra, Double precioVenta, int stock,
                          Date fechaVencimiento, CategoriaEntity categoriaEntity, TipoEntity tipoEntity, 
                          UbicacionEntity ubicacionEntity) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.fechaVencimiento = fechaVencimiento;
        this.categoriaEntity = categoriaEntity;
        this.tipoEntity = tipoEntity;
        this.ubicacionEntity = ubicacionEntity;
    }

    public ProductoEntity() {
    }
}
