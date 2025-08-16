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
        double recargo = 0.0;

        if (cuotas == 2) {
            recargo = 0.06;
        } else if (cuotas == 3) {
            recargo = 0.12;
        } else if (cuotas == 6) {
            recargo = 0.20;
        }

        return montoBase * (1 + recargo);
    }

    public int getCuotas() {
        return cuotas;
    }
}
