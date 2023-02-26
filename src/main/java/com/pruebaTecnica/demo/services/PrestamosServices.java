package com.pruebaTecnica.demo.services;

import com.pruebaTecnica.demo.Utils.Calculos;
import com.pruebaTecnica.demo.entity.Prestamo;
import com.pruebaTecnica.demo.entity.Tasas;
import com.pruebaTecnica.demo.models.PagosPendientes;
import com.pruebaTecnica.demo.repository.PrestamosRepository;
import com.pruebaTecnica.demo.repository.TasasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class PrestamosServices {

    //probar las otras funciones
    @Autowired
    PrestamosRepository prestamosRepository;

    @Autowired
    TasasRepository tasasRepository;

    public List<PagosPendientes> getListPagosPendientes(){
        List<PagosPendientes> pagos = new ArrayList<PagosPendientes>();
        PagosPendientes pagosPendientes = new PagosPendientes();
        for(int i = 0; i<10; i++){
            //PagosPendientes pagosPendientes = new PagosPendientes();
            pagosPendientes.setPago(1.1);
            pagosPendientes.setInteres(1.2);
            pagosPendientes.setIva(1.3);
            pagosPendientes.setMonto(1.4);
            pagosPendientes.setCliente(15);
            pagosPendientes.setTasa_interes(1.6);
            pagos.add(pagosPendientes);
        }
        return pagos;
    }

    public List<PagosPendientes> getCalculoPagoByClient(Long cliente, Date dateActual) {
        List<Prestamo> prestamos = prestamosRepository.findAllByClient(cliente);
        Calendar datePrestamo = new GregorianCalendar();

        PagosPendientes pagosPendientes;
        List<PagosPendientes> pagos = new ArrayList<PagosPendientes>();

        //calcular el plazo
        for(Prestamo prestamo: prestamos) {
            datePrestamo.setTime(prestamo.getFecha());

            int plazo = Calculos.plazo(dateActual, datePrestamo.getTime());
            Tasas tasa = tasasRepository.findByPlazoMinAndMax(plazo);
            Double interes = Calculos.intereses(prestamo.getMonto(),plazo, tasa.getTasa_interes(),360);
            Double iva = Calculos.iva(interes,0.16);
            Double pago = Calculos.pago(prestamo.getMonto(),interes,iva);

            pagosPendientes = new PagosPendientes();
            pagosPendientes.setPlazo(plazo);
            pagosPendientes.setPago(pago);
            pagosPendientes.setInteres(redondear(interes));
            pagosPendientes.setIva(redondear(iva));
            pagosPendientes.setMonto(prestamo.getMonto());
            pagosPendientes.setCliente(prestamo.getCliente().intValue());
            pagosPendientes.setTasa_interes(tasa.getTasa_interes());
            pagos.add(pagosPendientes);

            System.out.printf("resultado o: %s, %s, %s, %s \n", plazo,interes,iva,pago);
            System.out.printf("resultado: %s, %s, %s, %s \n", plazo,redondear(interes),redondear(iva),pago);

            }
        return pagos;
    }

    public Double redondear(Double valor){
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        return Double.parseDouble(decimalFormat.format(valor));
    }
}
