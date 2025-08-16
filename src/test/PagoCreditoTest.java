package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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

    @Test
    public void testCuotasInvalidasLanzanExcepcion() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new PagoCredito(5);
        });
        assertEquals("Cantidad de cuotas inválida. Solo se permite 2, 3 o 6.", ex.getMessage());
    }
}
