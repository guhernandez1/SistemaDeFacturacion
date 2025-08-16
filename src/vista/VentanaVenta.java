
package vista;

import javax.swing.*;
import Modelo.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaVenta extends JFrame {
    private static final long serialVersionUID = 1L;

    private Sistema sistema;
    private JComboBox<String> comboProductos;
    private JTextField campoCantidad;
    private JComboBox<String> comboPago;
    private JButton botonConfirmar;

    public VentanaVenta(Sistema sistema) {
        this.sistema = sistema;

        setTitle("Nueva Venta");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Producto:"));
        comboProductos = new JComboBox<>();
        for (Producto p : sistema.getProductos()) {
            comboProductos.addItem(p.getCodigo() + " - " + p.getDescripcion());
        }
        add(comboProductos);

        add(new JLabel("Cantidad:"));
        campoCantidad = new JTextField();
        add(campoCantidad);

        add(new JLabel("Medio de Pago:"));
        comboPago = new JComboBox<>(new String[]{"Efectivo", "Crédito", "Débito"});
        add(comboPago);

        botonConfirmar = new JButton("Confirmar Venta");
        add(botonConfirmar);

        botonConfirmar.addActionListener(e -> realizarVenta());

        
        JButton botonHistorial = new JButton("Ver historial");
        botonHistorial.addActionListener(ev -> new VentanaHistorialVentas(sistema));
        add(botonHistorial);
        
setVisible(true);
    }

    private void realizarVenta() {
        try {
            int index = comboProductos.getSelectedIndex();
            Producto producto = sistema.getProductos().get(index);
            int cantidad = Integer.parseInt(campoCantidad.getText());

            String medio = (String) comboPago.getSelectedItem();
            Pago medioPago;

            if (medio.equals("Efectivo")) {
                medioPago = new PagoEfectivo();
            } else if (medio.equals("Crédito")) {
                String cuotasStr = JOptionPane.showInputDialog(this, "Ingrese cantidad de cuotas (2, 3 o 6):");
                int cuotas = Integer.parseInt(cuotasStr);
                medioPago = new PagoCredito(cuotas);
            } else {
                medioPago = new PagoDebito();
            }

            Venta venta = new Venta(medioPago); 
            venta.agregarDetalle(producto, cantidad); 
            sistema.registrarVenta(venta); 

            double total = venta.calcularTotal();
            JOptionPane.showMessageDialog(this, "Venta registrada.\nTotal: $" + total);

            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}