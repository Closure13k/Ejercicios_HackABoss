package models;

import java.util.ArrayList;
import java.util.List;

public class Directorio {

    private final int id;
    private String nombre;
    private List<Directorio> subdirectorios;
    private List<String> archivos;

    public Directorio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        subdirectorios = new ArrayList<>();
        archivos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Directorio> getSubdirectorios() {
        return subdirectorios;
    }

    public void setSubdirectorios(List<Directorio> subdirectorios) {
        this.subdirectorios = subdirectorios;
    }

    public List<String> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<String> archivos) {
        this.archivos = archivos;
    }
}
