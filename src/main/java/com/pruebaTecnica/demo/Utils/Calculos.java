package com.pruebaTecnica.demo.Utils;


import com.pruebaTecnica.demo.models.PagosPendientes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class Calculos {

    public static Integer plazo(Date dateNow, Date datePrestamo){
        Long differenceMiliseconds = dateNow.getTime() - datePrestamo.getTime();
        Long differenceTime = TimeUnit.MILLISECONDS.toDays(differenceMiliseconds);
        return differenceTime.intValue();
    }

    public static Double intereses(double monto, double plazo, double tasa_interes, int dias_comerciales){
        Double interes = monto * plazo * (tasa_interes/dias_comerciales);
        return interes;
    }

    public static Double iva(Double interes, Double tasa_iva){
        return interes * tasa_iva;
    }

    public static Double pago(Double prestamo_monto,double interes, double iva){
        return prestamo_monto + interes + iva;
    }
}
