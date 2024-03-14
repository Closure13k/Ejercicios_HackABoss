package models.ej1;

public class Ropa extends Producto {
    private String talla;
    private String material;

    public Ropa(String nombre, double precio, String talla, String material) {
        super(nombre, precio);
        this.talla = talla;
        this.material = material;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Ropa{" +
                "talla='" + talla + '\'' +
                ", material='" + material + '\'' +
                "} " + super.toString();
    }
}
