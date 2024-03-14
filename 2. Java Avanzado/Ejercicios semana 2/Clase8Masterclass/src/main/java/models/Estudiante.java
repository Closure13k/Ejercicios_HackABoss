package models;

import java.util.List;

public class Estudiante {
    private String nombre;
    private int edad;
    private List<Double> calificaciones;

    public Estudiante() {
    }

    public Estudiante(String nombre, int edad, List<Double> calificaciones) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = calificaciones;
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

    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }


    public boolean esMayorDeEdad() {
        return this.getEdad() > 18;
    }

    public String getNombrePromedio() {
        return "%s - %.2f".formatted(this.getNombre(), this.getPromedioNotas());
    }
    public double getPromedioNotas() {
        return this.getCalificaciones().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", calificaciones=" + calificaciones +
                '}';
    }
}
