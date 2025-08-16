package vista;

import Modelo.Producto;
import Modelo.Sistema;
import Modelo.Venta;
import Modelo.DetalleVenta;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaHistorialVentas extends JFrame {
    private Sistema sistema;
    private JTextArea areaHistorial;
    private JTextArea areaStockBajo;

    public VentanaHistorialVentas(Sistema sistema) {
        this.sistema = sistema;
        setTitle("Historial de Ventas y Stock Bajo");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de historial
        areaHistorial = new JTextArea();
        areaHistorial.setEditable(false);
        JScrollPane scrollHistorial = new JScrollPane(areaHistorial);
        scrollHistorial.setBorder(BorderFactory.createTitledBorder("Historial de Ventas"));

        // Panel de stock mínimo
        areaStockBajo = new JTextArea();
        areaStockBajo.setEditable(false);
        JScrollPane scrollStock = new JScrollPane(areaStockBajo);
        scrollStock.setBorder(BorderFactory.createTitledBorder("Productos con Stock Bajo"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollHistorial, scrollStock);
        splitPane.setResizeWeight(0.6);
        add(splitPane, BorderLayout.CENTER);

        cargarHistorial();
        cargarStockBajo();

        setVisible(true);
    }

    private void cargarHistorial() {
        StringBuilder sb = new StringBuilder();
        List<Venta> ventas = sistema.getVentas();
        if (ventas.isEmpty()) {
            sb.append("No hay ventas registradas.\n");
        } else {
            for (Venta venta : ventas) {
                sb.append("Venta:\n");
                for (DetalleVenta d : venta.getDetalles()) {
                    sb.append("- ").append(d.getProducto().getDescripcion())
                      .append(" x").append(d.getCantidad())
                      .append(" @ $").append(d.getProducto().getPrecioUnitario())
                      .append(" = $").append(d.calcularSubtotal()).append("\n");
                }
                sb.append("Total: $").append(venta.calcularTotal()).append("\n");
                sb.append("Medio de pago: ").append(venta.getMedioDePago().getClass().getSimpleName()).append("\n");
                sb.append("-----------\n");
            }
        }
        areaHistorial.setText(sb.toString());
    }

    private void cargarStockBajo() {
        StringBuilder sb = new StringBuilder();
        List<Producto> bajos = sistema.getProductosEnStockMinimo();
        if (bajos.isEmpty()) {
            sb.append("Todos los productos tienen stock suficiente.");
        } else {
            for (Producto p : bajos) {
                sb.append("- ").append(p.getDescripcion())
                  .append(" (stock: ").append(p.getStock())
                  .append(", mínimo: ").append(p.getStockMinimo()).append(")\n");
            }
        }
        areaStockBajo.setText(sb.toString());
    }
}
