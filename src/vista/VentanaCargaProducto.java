package vista;

import javax.swing.*;

import Modelo.Producto;
import Modelo.Sistema;
import java.awt.*;

public class VentanaCargaProducto extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Sistema sistema;

    private JTextField campoCodigo, campoDescripcion, campoPrecio, campoStock, campoStockMin;

    public VentanaCargaProducto(Sistema sistema) {
        this.sistema = sistema;

        setTitle("Carga de Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Código:"));
        campoCodigo = new JTextField();
        add(campoCodigo);

        add(new JLabel("Descripción:"));
        campoDescripcion = new JTextField();
        add(campoDescripcion);

        add(new JLabel("Precio Unitario:"));
        campoPrecio = new JTextField();
        add(campoPrecio);

        add(new JLabel("Stock Inicial:"));
        campoStock = new JTextField();
        add(campoStock);

        add(new JLabel("Stock Mínimo:"));
        campoStockMin = new JTextField();
        add(campoStockMin);

        JButton botonAgregar = new JButton("Agregar Producto");
        add(botonAgregar);

        JButton botonVerCatalogo = new JButton("Ver Productos");
        add(botonVerCatalogo);

        botonAgregar.addActionListener(e -> agregarProducto());

        botonVerCatalogo.addActionListener(e -> verProductos());

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

            campoCodigo.setText("");
            campoDescripcion.setText("");
            campoPrecio.setText("");
            campoStock.setText("");
            campoStockMin.setText("");

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
