import models.ExploradorTareas;
import models.Tarea;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static models.ExploradorTareas.mostrarTareas;

public class Ejercicio2 {
    /**
     * Desarrolla una aplicación para organizar tareas en un proyecto. Utiliza la recursividad
     * para crear una estructura jerárquica de tareas. Cada tarea puede tener subtareas asociadas,
     * y estas subtareas también pueden tener sus propias subtareas, creando así una estructura de "árbol de tareas".
     * <p>
     * El programa debe permitir al usuario agregar tareas principales y subtareas de manera
     * recursiva. Además, debe ofrecer la capacidad de visualizar la estructura completa de tareas
     * con sus respectivas subtareas.
     */
    public static void main(String[] args) {
        Tarea proyecto = new Tarea("");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Asigna un nombre al proyecto: ");
        proyecto.setNombre(scanner.nextLine());

        int opcion = 0;
        do {
            System.out.print("""
                    1. Agregar tarea
                    2. Mostrar tareas
                    3. Salir
                    Opción: 
                    """
            );
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1 -> generarTarea(scanner, proyecto);
                    case 2 -> System.out.println(mostrarTareas(proyecto, 0));
                    case 3 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error al leer un dato.\n" + e.getMessage());
                scanner.nextLine();
            }
        } while (opcion != 3);

        System.out.println("Hasta luego! Este es el resultado final:");
        System.out.println(mostrarTareas(proyecto, 0));
    }


    private static void generarTarea(Scanner scanner, Tarea proyecto) {
        System.out.print("Nombre de la tarea: ");
        String nombre = scanner.nextLine();
        System.out.print("Id de la tarea padre: ");
        int idPadre = scanner.nextInt();
        scanner.nextLine();
        Tarea tarea = new Tarea(nombre);
        Tarea tareaPadre = ExploradorTareas.buscarTarea(proyecto, idPadre);
        if (tareaPadre != null) {
            tareaPadre.getSubtareas().add(tarea);
        } else {
            System.out.println("No se encontró la tarea padre");
        }
    }

}
