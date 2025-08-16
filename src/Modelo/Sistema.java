package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Producto> productos;
    private List<Venta> ventas;

    public Sistema() {
        productos = new ArrayList<>();
        ventas = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void registrarVenta(Venta v) {
        ventas.add(v);
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public List<Producto> getProductosEnStockMinimo() {
        List<Producto> lista = new ArrayList<>();
        for (Producto p : productos) {
            if (p.estaEnStockMinimo()) {
                lista.add(p);
            }
        }
        return lista;
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
}
