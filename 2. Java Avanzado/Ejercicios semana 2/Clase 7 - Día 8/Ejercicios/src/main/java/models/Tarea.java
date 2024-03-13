package models;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
    private static int idCounter = 0;

    private int id;

    private String nombre;
    private List<Tarea> subtareas;

    public Tarea(String nombre) {
        this.id = ++idCounter;
        this.nombre = nombre;
        this.subtareas = new ArrayList<>();
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

    public List<Tarea> getSubtareas() {
        return subtareas;
    }

    public void setSubtareas(List<Tarea> subtareas) {
        this.subtareas = subtareas;
    }
    public String getIdNombre() {
        return "[" + id + "] " + nombre;
    }
}
