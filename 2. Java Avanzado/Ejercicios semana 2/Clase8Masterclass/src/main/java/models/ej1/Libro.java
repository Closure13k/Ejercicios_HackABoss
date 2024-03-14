package models.ej1;

public class Libro extends Producto {
    private String autor;

    public Libro(String nombre, double precio, String autor) {
        super(nombre, precio);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                "} " + super.toString();
    }
}
