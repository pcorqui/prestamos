package com.pruebaTecnica.demo.entity;

import com.pruebaTecnica.demo.Enum.Estado;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cliente;
    private Date fecha;
    private Double monto;
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public com.pruebaTecnica.demo.Enum.Estado getEstado() {
        return estado;
    }

    public void setEstado(com.pruebaTecnica.demo.Enum.Estado estado) {
        this.estado = estado;
    }
}
