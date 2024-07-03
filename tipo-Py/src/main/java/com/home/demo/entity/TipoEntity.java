package com.home.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipo;
	private String nombreTipo;
	private String detalleTipo;
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	public String getDetalleTipo() {
		return detalleTipo;
	}
	public void setDetalleTipo(String detalleTipo) {
		this.detalleTipo = detalleTipo;
	}
	public TipoEntity(int idTipo, String nombreTipo, String detalleTipo) {
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
		this.detalleTipo = detalleTipo;
	}
	public TipoEntity() {
	}
	
	
	
	
	
	
	
	
}
