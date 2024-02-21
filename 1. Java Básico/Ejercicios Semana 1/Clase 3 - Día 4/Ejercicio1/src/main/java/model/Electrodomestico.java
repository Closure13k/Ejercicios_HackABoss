package model;

import java.util.Objects;

//? Crear una clase llamada Electrodomestico (sin tilde, recuerda que los nombres de clases y variables no llevan tilde)
//? con los siguientes atributos: cod, marca, modelo, consumo y color.
public class Electrodomestico {
    private String cod;
    private String marca;
    private String modelo;
    private String consumo;
    private String color;

    public Electrodomestico() {
    }

    public Electrodomestico(String cod, String marca, String modelo, String consumo, String color) {
        this.cod = cod;
        this.marca = marca;
        this.modelo = modelo;
        this.consumo = consumo;
        this.color = color;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public String getCod() {
        return cod;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getConsumo() {
        return consumo;
    }

    public String getColor() {
        return color;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //</editor-fold>
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electrodomestico that = (Electrodomestico) o;
        return Objects.equals(cod, that.cod) && Objects.equals(marca, that.marca) && Objects.equals(modelo, that.modelo) && Objects.equals(consumo, that.consumo) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, marca, modelo, consumo, color);
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "cod='" + cod + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", consumo='" + consumo + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
