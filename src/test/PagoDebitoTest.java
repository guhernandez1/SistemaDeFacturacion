package test;

import static org.junit.Assert.*;
import org.junit.Test;
import Modelo.PagoDebito;

public class PagoDebitoTest {

    @Test
    public void testCalcularTotalSinDescuentoNiRecargo() {
        PagoDebito pago = new PagoDebito();
        double total = pago.calcularTotal(100.0);
        assertEquals(100.0, total, 0.001);
    }
}
