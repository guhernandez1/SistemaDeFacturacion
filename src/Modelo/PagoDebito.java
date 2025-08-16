package Modelo;

public class PagoDebito extends Pago {
    @Override
    public double calcularTotal(double montoBase) {
        return montoBase; 
    }
}
