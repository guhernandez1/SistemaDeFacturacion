package Modelo;

public class DetalleVenta {
    private Producto producto;
    private int cantidad;

    public DetalleVenta(Producto producto, int cantidad) {
        if (!producto.hayStock(cantidad)) {
            throw new IllegalArgumentException("No hay stock suficiente para este producto.");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        producto.reducirStock(cantidad);
    }

    public double calcularSubtotal() {
        return producto.getPrecioUnitario() * cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
}
