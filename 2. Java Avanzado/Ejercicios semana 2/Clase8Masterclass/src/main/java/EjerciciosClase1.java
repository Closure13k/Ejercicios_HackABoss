import models.Estudiante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Ejercicio Nº 1: Streams y Optionals – Gestión de estudiantes
 * Crea un sistema de gestión de estudiantes donde cada estudiante tiene un nombre,
 * una lista de calificaciones(Double) y una edad.
 * Cargar 3 calificaciones como minimo para cada alumno. Ejemplo:
 * new Estudiante("Carlos", Arrays.asList(8.0, 9.0, 7.0), 20)
 * Sobrescribir el método toString de la clase Estudiante.
 * En el main, cargar un listado de estudiantes (mínimo 5 estudiantes) e implementa
 * las siguientes operaciones utilizando Streams y Optionals:
 * •	Filtrar los estudiantes mayores de 18 años y mostrarlos en una sola sentencia.
 * •	Para cada estudiante, calcular y mostrar el promedio de sus calificaciones.
 */

public class EjerciciosClase1 {

    public static void main(String[] args) {
        List<Estudiante> estudiantes = getEstudiantes();

        // Filtrar los estudiantes mayores de 18 años y mostrarlos en una sola sentencia.
        estudiantes.stream()
                .filter(Estudiante::esMayorDeEdad)
                .forEach(System.out::println);

        // Para cada estudiante, calcular y mostrar el promedio de sus calificaciones.
        estudiantes.stream()
                .map(Estudiante::getNombrePromedio)
                .forEach(System.out::println);

        estudiantes.forEach(
                estudiante -> {
                    double promedio = estudiante.getCalificaciones()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .orElse(0);
                    System.out.println(estudiante.getNombre() + " - " + promedio);
                }
        );

    }

    private static List<Estudiante> getEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("Juan Perez", 20, List.of(8.5, 7.8, 9.0)));
        estudiantes.add(new Estudiante("Maria Rodriguez", 22, List.of(6.5, 7.2, 8.0)));
        estudiantes.add(new Estudiante("Carlos Gomez", 21, List.of(7.0, 7.5, 8.5)));
        estudiantes.add(new Estudiante("Luisa Martinez", 23, List.of(9.0, 9.0, 9.0)));
        estudiantes.add(new Estudiante("Ana Fernandez", 17, List.of(8.0, 8.5, 7.5)));
        estudiantes.add(new Estudiante("Pedro Sanchez", 20, List.of(6.8, 7.2, 7.0)));
        estudiantes.add(new Estudiante("Laura Diaz", 22, List.of(7.5, 8.0, 6.5)));
        estudiantes.add(new Estudiante("Alejandro Vazquez", 21, List.of(8.5, 8.5, 8.0)));
        estudiantes.add(new Estudiante("Sofia Lopez", 16, List.of(7.0, 6.5, 6.8)));
        estudiantes.add(new Estudiante("Valeria Gomez", 24, List.of(9.0, 8.8, 9.5)));

        return estudiantes;
    }

}
