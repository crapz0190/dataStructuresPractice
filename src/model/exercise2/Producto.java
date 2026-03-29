package model.exercise2;

public class Producto {
    String nombre;
    String categoria;
    double precio;

    Producto(String nombre, String categoria, double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}
