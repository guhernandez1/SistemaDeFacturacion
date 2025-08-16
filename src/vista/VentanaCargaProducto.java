package vista;

import javax.swing.*;
import Modelo.Producto;
import Modelo.Sistema;
import java.awt.*;

public class VentanaCargaProducto extends JFrame {
    private static final long serialVersionUID = 1L;
    private Sistema sistema;
    private JTextField campoCodigo, campoDescripcion, campoPrecio, campoStock, campoStockMin;

    public VentanaCargaProducto(Sistema sistema) {
        this.sistema = sistema;
        setTitle("Carga de Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        campoCodigo = new JTextField();
        campoDescripcion = new JTextField();
        campoPrecio = new JTextField();
        campoStock = new JTextField();
        campoStockMin = new JTextField();

        add(new JLabel("Código:")); add(campoCodigo);
        add(new JLabel("Descripción:")); add(campoDescripcion);
        add(new JLabel("Precio Unitario:")); add(campoPrecio);
        add(new JLabel("Stock Inicial:")); add(campoStock);
        add(new JLabel("Stock Mínimo:")); add(campoStockMin);

        JButton botonAgregar = new JButton("Agregar Producto");
        JButton botonVerCatalogo = new JButton("Ver Productos");
        JButton botonVenta = new JButton("Ir a Ventas");

        add(botonAgregar); add(botonVerCatalogo);
        add(botonVenta);

        botonAgregar.addActionListener(e -> agregarProducto());
        botonVerCatalogo.addActionListener(e -> verProductos());
        botonVenta.addActionListener(e -> new VentanaVenta(sistema));

        
        JButton botonHistorial = new JButton("Ver historial");
        botonHistorial.addActionListener(ev -> new VentanaHistorialVentas(sistema));
        add(botonHistorial);
        
setVisible(true);
    }

    private void agregarProducto() {
        try {
            String codigo = campoCodigo.getText();
            String descripcion = campoDescripcion.getText();
            double precio = Double.parseDouble(campoPrecio.getText());
            int stock = Integer.parseInt(campoStock.getText());
            int stockMin = Integer.parseInt(campoStockMin.getText());

            Producto producto = new Producto(codigo, descripcion, precio, stock, stockMin);
            sistema.agregarProducto(producto);
            JOptionPane.showMessageDialog(this, "Producto agregado exitosamente");

            campoCodigo.setText(""); campoDescripcion.setText(""); campoPrecio.setText("");
            campoStock.setText(""); campoStockMin.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos numéricos.");
        }
    }

    private void verProductos() {
        StringBuilder sb = new StringBuilder("Catálogo de productos:\n");
        for (Producto p : sistema.getProductos()) {
            sb.append(p.getCodigo()).append(" - ")
              .append(p.getDescripcion()).append(" | $")
              .append(p.getPrecioUnitario()).append(" | Stock: ")
              .append(p.getStock()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        new VentanaCargaProducto(sistema);
    }
}