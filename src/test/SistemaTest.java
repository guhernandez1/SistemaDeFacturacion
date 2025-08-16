package test;

import Modelo.Producto;
import Modelo.Sistema;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SistemaTest {

    @Test
    public void testAgregarYListarProductos() {
        Sistema sistema = new Sistema();
        Producto producto = new Producto("007", "Fideos", 400.0, 10, 2);
        sistema.agregarProducto(producto);

        List<Producto> productos = sistema.getProductos();
        assertEquals(1, productos.size());
        assertEquals("Fideos", productos.get(0).getDescripcion());
    }

    @Test
    public void testProductosEnStockMinimo() {
        Sistema sistema = new Sistema();
        Producto p1 = new Producto("008", "Azúcar", 250.0, 2, 2); // stock mínimo
        Producto p2 = new Producto("009", "Sal", 100.0, 5, 2); // no mínimo

        sistema.agregarProducto(p1);
        sistema.agregarProducto(p2);

        List<Producto> minimos = sistema.getProductosEnStockMinimo();
        assertEquals(1, minimos.size());
        assertEquals("Azúcar", minimos.get(0).getDescripcion());
    }
}