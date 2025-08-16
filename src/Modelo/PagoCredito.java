package Modelo;

public class PagoCredito extends Pago {
    private int cuotas;

    public PagoCredito(int cuotas) {
        if (cuotas != 2 && cuotas != 3 && cuotas != 6) {
            throw new IllegalArgumentException("Cantidad de cuotas inválida. Solo se permite 2, 3 o 6.");
        }
        this.cuotas = cuotas;
    }

    @Override
    public double calcularTotal(double montoBase) {
        double recargo = switch (cuotas) {
            case 2 -> 0.06;
            case 3 -> 0.12;
            case 6 -> 0.20;
            default -> 0.0;
        };
        return montoBase * (1 + recargo);
    }

    public int getCuotas() {
        return cuotas;
    }
}
