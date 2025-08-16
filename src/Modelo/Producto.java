package Modelo;

public class Producto {
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private int stock;
    private int stockMinimo;

    public Producto(String codigo, String descripcion, double precioUnitario, int stock, int stockMinimo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
    }

    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    public void reducirStock(int cantidad) {
        if (hayStock(cantidad)) {
            stock -= cantidad;
        }
    }

    public boolean estaEnStockMinimo() {
        return stock <= stockMinimo;
    }

    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioUnitario() { return precioUnitario; }
    public int getStock() { return stock; }
    public int getStockMinimo() { return stockMinimo; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setStock(int stock) { this.stock = stock; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

	public Object getCantidadEnStock() {
		// TODO Auto-generated method stub
		return null;
	}
}
