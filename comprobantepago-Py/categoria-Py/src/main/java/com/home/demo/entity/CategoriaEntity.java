package com.home.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoriaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	private String nombreCategoria;
	private String detalle_categoria;
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
	public String getDetalle_categoria() {
		return detalle_categoria;
	}
	public void setDetalle_categoria(String detalle_categoria) {
		this.detalle_categoria = detalle_categoria;
	}
	public CategoriaEntity(int idCategoria, String nombreCategoria, String detalle_categoria) {
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.detalle_categoria = detalle_categoria;
	}
	public CategoriaEntity() {
	}
	
	
	
	
	
	
}
