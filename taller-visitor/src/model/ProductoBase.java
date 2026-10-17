package model;

public abstract class ProductoBase implements Producto {
    private final String nombre;
    private final double precio;
    private final double pesoGramos;

    protected ProductoBase(String nombre, double precio, double pesoGramos) {
        this.nombre = nombre;
        this.precio = precio;
        this.pesoGramos = pesoGramos;
    }

    @Override public String getNombre() { return nombre; }
    @Override public double getPrecio() { return precio; }
    @Override public double getPesoGramos() { return pesoGramos; }
}
