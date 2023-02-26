package com.pruebaTecnica.demo.Enum;

public enum Estado {

    PENDIENTE("PENDIENTE"),
    PAGADO("PAGADO");

    private String clave;

    Estado(String clave){
        this.clave = clave;
    }


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }



}
