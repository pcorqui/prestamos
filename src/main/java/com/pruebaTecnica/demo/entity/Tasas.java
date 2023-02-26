package com.pruebaTecnica.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tasas")
public class Tasas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    private Integer plazo_max;
    private Integer plazo_min;
    private Double tasa_interes;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getPlazo_max() {
        return plazo_max;
    }

    public void setPlazo_max(Integer plazo_max) {
        this.plazo_max = plazo_max;
    }

    public Integer getPlazo_min() {
        return plazo_min;
    }

    public void setPlazo_min(Integer plazo_min) {
        this.plazo_min = plazo_min;
    }

    public Double getTasa_interes() {
        return tasa_interes;
    }

    public void setTasa_interes(Double tasa_interes) {
        this.tasa_interes = tasa_interes;
    }
}
