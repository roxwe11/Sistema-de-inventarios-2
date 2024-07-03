package com.home.demo.dto;

public class CategoriaDto {
    private int idCategoria;
    private String nombreCategoria;
    private String detalleCategoria;

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
}
