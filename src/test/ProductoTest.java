package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Modelo.Producto;

public class ProductoTest {

    @Test
    public void testReducirStock() {
        Producto producto = new Producto("001", "Yerba", 800.0, 10, 3);
        producto.reducirStock(2);
        assertEquals(8, producto.getCantidadEnStock());
    }

    @Test
    public void testReducirStockInsuficiente() {
        Producto producto = new Producto("002", "Aceite", 1200.0, 1, 1);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            producto.reducirStock(2);
        });
        assertEquals("No hay suficiente stock", ex.getMessage());
    }

    @Test
    public void testEstaEnStockMinimoTrue() {
        Producto producto = new Producto("003", "Harina", 500.0, 2, 2);
        assertTrue(producto.estaEnStockMinimo());
    }

    @Test
    public void testEstaEnStockMinimoFalse() {
        Producto producto = new Producto("004", "Leche", 600.0, 5, 2);
        assertFalse(producto.estaEnStockMinimo());
    }
}