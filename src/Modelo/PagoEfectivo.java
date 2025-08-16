package Modelo;

public class PagoEfectivo extends Pago {
    @Override
    public double calcularTotal(double montoBase) {
        return montoBase * 0.9; 
    }
}
