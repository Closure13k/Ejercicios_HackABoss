package models.ej1;

public class Electronico extends Producto {
    private String marca;

    public Electronico(String nombre, double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Electronico{" +
                "marca='" + marca + '\'' +
                "} " + super.toString();
    }
}
