package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.PagoEfectivo;

public class PagoEfectivoTest {

    @Test
    public void testCalcularTotalConDescuento() {
        PagoEfectivo pago = new PagoEfectivo();
        double total = pago.calcularTotal(100.0);
        assertEquals(90.0, total, 0.001);
    }
}
