package com.home.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.Date;

@Entity
public class ComprobantePagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComprobantePago;
    private Date fechaComprobantePago;
    private String nombre_comprobante;
    private Double op_gravada;
    private Double igv;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "idFormapago")
    private FormaPagoEntity formaPagoEntity;

    @OneToOne(mappedBy = "comprobantePagoEntity")
    private VentaEntity ventaEntity;

    // Getters y setters

    public int getIdComprobantePago() {
        return idComprobantePago;
    }

    public void setIdComprobantePago(int idComprobantePago) {
        this.idComprobantePago = idComprobantePago;
    }

    public Date getFechaComprobantePago() {
        return fechaComprobantePago;
    }

    public void setFechaComprobantePago(Date fechaComprobantePago) {
        this.fechaComprobantePago = fechaComprobantePago;
    }

    public String getNombre_comprobante() {
        return nombre_comprobante;
    }

    public void setNombre_comprobante(String nombre_comprobante) {
        this.nombre_comprobante = nombre_comprobante;
    }

    public Double getOp_gravada() {
        return op_gravada;
    }

    public void setOp_gravada(Double op_gravada) {
        this.op_gravada = op_gravada;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public FormaPagoEntity getFormaPagoEntity() {
        return formaPagoEntity;
    }

    public void setFormaPagoEntity(FormaPagoEntity formaPagoEntity) {
        this.formaPagoEntity = formaPagoEntity;
    }

    public VentaEntity getVentaEntity() {
        return ventaEntity;
    }

    public void setVentaEntity(VentaEntity ventaEntity) {
        this.ventaEntity = ventaEntity;
    }

    public ComprobantePagoEntity(int idComprobantePago, Date fechaComprobantePago, String nombre_comprobante,
                                 Double op_gravada, Double igv, UsuarioEntity usuarioEntity, FormaPagoEntity formaPagoEntity,
                                 VentaEntity ventaEntity) {
        this.idComprobantePago = idComprobantePago;
        this.fechaComprobantePago = fechaComprobantePago;
        this.nombre_comprobante = nombre_comprobante;
        this.op_gravada = op_gravada;
        this.igv = igv;
        this.usuarioEntity = usuarioEntity;
        this.formaPagoEntity = formaPagoEntity;
        this.ventaEntity = ventaEntity;
    }

    public ComprobantePagoEntity() {
    }
}
