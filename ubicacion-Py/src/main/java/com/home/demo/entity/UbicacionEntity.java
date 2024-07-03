package com.home.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UbicacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idUbicacion;
	private String nombre_ubicacion;
	public int getIdUbicacion() {
		return idUbicacion;
	}
	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}
	public String getNombre_ubicacion() {
		return nombre_ubicacion;
	}
	public void setNombre_ubicacion(String nombre_ubicacion) {
		this.nombre_ubicacion = nombre_ubicacion;
	}
	public UbicacionEntity(int idUbicacion, String nombre_ubicacion) {
		this.idUbicacion = idUbicacion;
		this.nombre_ubicacion = nombre_ubicacion;
	}
	public UbicacionEntity() {
		
	}
	

	
	
	
}
