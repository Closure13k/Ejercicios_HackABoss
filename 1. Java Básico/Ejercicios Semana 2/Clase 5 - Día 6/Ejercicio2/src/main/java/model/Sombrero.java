package model;

public class Sombrero extends Vestimenta {
    private String tipo;
    private String tamano;

    public Sombrero(int codigo, String nombre, double precio, String marca, String talla, String color, String tipo, String tamano) {
        super(codigo, nombre, precio, marca, talla, color);
        this.tipo = tipo;
        this.tamano = tamano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    @Override
    public void mostrarMensaje() {
        System.out.println("Este sombrero es de marca: " + getTipo());
    }
}
