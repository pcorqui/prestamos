package com.pruebaTecnica.demo.models;

public class PagosPendientes {

    private Integer cliente;
    private int plazo;
    private Double Tasa_interes;
    private Double Monto;
    private Double interes;
    private Double iva;
    private Double Pago;

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Double getTasa_interes() {
        return Tasa_interes;
    }

    public void setTasa_interes(Double tasa_interes) {
        Tasa_interes = tasa_interes;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double monto) {
        Monto = monto;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getPago() {
        return Pago;
    }

    public void setPago(Double pago) {
        Pago = pago;
    }
}
