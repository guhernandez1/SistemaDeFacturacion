package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private List<DetalleVenta> detalles;
    private Pago medioDePago;

    public Venta(Pago medioDePago) {
        this.detalles = new ArrayList<>();
        this.medioDePago = medioDePago;
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        DetalleVenta detalle = new DetalleVenta(producto, cantidad);
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double subtotal = 0;
        for (DetalleVenta d : detalles) {
            subtotal += d.calcularSubtotal();
        }
        return medioDePago.calcularTotal(subtotal);
    }

    // Getters
    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public Pago getMedioDePago() {
        return medioDePago;
    }
}
