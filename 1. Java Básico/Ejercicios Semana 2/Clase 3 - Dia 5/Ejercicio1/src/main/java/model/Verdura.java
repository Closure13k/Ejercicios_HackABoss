package model;

/**
 * Verdura, que tenga los siguientes atributos: id, nombre, color, calorías,
 * debeCocinarse (tener en cuenta todos sus atributos, constructores, métodos
 * getters y setters).
 */
public class Verdura {
    private int id;
    private String nombre;
    private String color;
    private int calorias;

    public Verdura() {
    }

    public Verdura(int id, String nombre, String color, int calorias) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.calorias = calorias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Verdura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", calorias=" + calorias +
                '}';
    }
}
