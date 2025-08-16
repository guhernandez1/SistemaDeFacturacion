package test;

import static org.junit.Assert.*;
import org.junit.Test;
import Modelo.PagoCredito;

public class PagoCreditoTest {

    @Test
    public void testCalcularTotal2Cuotas() {
        PagoCredito pago = new PagoCredito(2);
        double total = pago.calcularTotal(100.0);
        assertEquals(106.0, total, 0.001);
    }

    @Test
    public void testCalcularTotal3Cuotas() {
        PagoCredito pago = new PagoCredito(3);
        double total = pago.calcularTotal(100.0);
        assertEquals(112.0, total, 0.001);
    }

    @Test
    public void testCalcularTotal6Cuotas() {
        PagoCredito pago = new PagoCredito(6);
        double total = pago.calcularTotal(100.0);
        assertEquals(120.0, total, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCuotasInvalidasLanzanExcepcion() {
        new PagoCredito(5); 
    }
}

