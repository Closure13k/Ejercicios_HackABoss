package models;

/**
 * Inicia creando una clase Vehículo con los atributos modelo, marca y costo, luego
 * crea una lista de vehículos. Crea además los constructores de las clases y los
 * métodos Setter y Getter.
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    private double costo;

    public Vehiculo(String marca, String modelo, double costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    public Vehiculo() {
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getMarcaPrecio() {
        return this.marca + " - " + this.costo;
    }

    public String getMarcaModelo() {
        return this.marca + " " + this.modelo;
    }

    @Override
    public String toString() {
        return "models.Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }
}
