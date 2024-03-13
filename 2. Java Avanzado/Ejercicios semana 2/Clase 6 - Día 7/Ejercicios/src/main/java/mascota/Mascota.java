package mascota;


import java.util.Map;

public class Mascota<T> {

    public static final Map<Integer, String> ESPECIES = Map.of(
            1, "Perro",
            2, "Gato",
            3, "Ave",
            4, "Reptil"
    );

    private int id;
    private String nombre;
    private int edad;
    private T especie;

    public Mascota(int id, String nombre, int edad, T especie) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
    }

    public Mascota() {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public T getEspecie() {
        return especie;
    }

    public void setEspecie(T especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", especie=" + especie +
                '}';
    }

    //Sobreescribe el equals para comparar por el id.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mascota<?> mascota = (Mascota<?>) obj;
        return id == mascota.id;
    }
}
