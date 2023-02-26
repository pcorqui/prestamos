package com.pruebaTecnica.demo.controller;

import com.pruebaTecnica.demo.models.PagosPendientes;
import com.pruebaTecnica.demo.Utils.Calculos;
import com.pruebaTecnica.demo.services.PrestamosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("prestamos")
public class PrestamosController {

    @Autowired
    PrestamosServices prestamosServices;

//    @GetMapping("plazo")
//    public int prestamo(){
//
//        //return PrestamosServices.Plazo(new Date("15-02-2021"),new Date("10-01-2021"));
//    }

    @GetMapping("pagos")
    public List<PagosPendientes> pagosPendientes(){
        return prestamosServices.getListPagosPendientes();
    }

    @GetMapping("prueba")
    public List<PagosPendientes> prueba(@RequestParam Long cliente, @RequestParam Date fecha){
        Calendar cFechaViaje = new GregorianCalendar();
        cFechaViaje.setTime(fecha);
        return prestamosServices.getCalculoPagoByClient(cliente, cFechaViaje.getTime());
    }
}
