package test;

import Modelo.Producto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Modelo.DetalleVenta;

public class DetalleVentaTest {

    @Test
    public void testCrearDetalleVentaReduceStock() {
        Producto producto = new Producto("005", "Galletitas", 300.0, 10, 2);
        DetalleVenta detalle = new DetalleVenta(producto, 3);
        assertEquals(7, producto.getCantidadEnStock());
        assertEquals(900.0, detalle.calcularSubtotal(), 0.01);
    }

    @Test
    public void testCrearDetalleVentaSinStock() {
        Producto producto = new Producto("006", "Café", 1200.0, 1, 1);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new DetalleVenta(producto, 2);
        });
        assertEquals("No hay suficiente stock", ex.getMessage());
    }
}
