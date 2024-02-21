package model;

import java.util.Objects;

//? Crear una clase Persona, que tenga los siguientes atributos:
//? id, nombre, edad, dirección y número de teléfono
//? (tener en cuenta todos sus atributos, constructores y métodos getters y setters).
public class Persona {
    private Integer id;
    private String nombre;
    private Integer edad;
    private String direccion;
    private String numeroTelefono;

    public Persona() {
    }

    public Persona(Integer id, String nombre, Integer edad, String direccion, String numeroTelefono) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
