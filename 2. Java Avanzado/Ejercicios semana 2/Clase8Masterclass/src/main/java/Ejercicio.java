import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;

public class Ejercicio {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>(getVehiculos());

    /*
        Haciendo uso del método sort en la lista de Vehículos con
        expresiones lambda, obtén una lista de vehículos ordenados
        por precio de menor a mayor, imprime por pantalla el resultado.
    */
        //?1
        vehiculos.sort((v1, v2) -> (int) (v2.getCosto() - v1.getCosto()));

        vehiculos.sort(comparingDouble(Vehiculo::getCosto).reversed());

        // De la misma forma anterior imprime una lista ordenada
        // por marca y a su vez por precio.
        System.out.println("Ordenados por marca y precio:");
        vehiculos.stream()
                .sorted(comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .map(Vehiculo::getMarcaPrecio)
                //.toList() // Si fuera necesario almacenarlos.
                .forEach(System.out::println);

    /*
        Se desea extraer una lista de vehículos con precio no mayor
        a 1000, luego otra con precios mayor o igual 1000 y por
        último, obtén el promedio total de precios de toda la
        lista de vehículos.
    ---------------------------------------------------------------------
        Podemos utilizar un mapa y sacar las dos listas de una.
        Como sólo hay dos casos, podemos usar partitioningBy,
        que nos devuelve un Map<Boolean, List<Vehiculo>>.
    */
        Predicate<Vehiculo> esMenorAMil = v -> v.getCosto() < 1000;
        Map<Boolean, List<Vehiculo>> vehiculosPorPrecio = vehiculos.stream()
                .sorted(comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getModelo))
                .collect(partitioningBy(esMenorAMil));
        //Imprimimos las listas
        vehiculosPorPrecio.entrySet()
                .stream()
                .map(Ejercicio::entradaVehiculoComoString)
                .forEach(System.out::println);


        //Promedio de precios
        System.out.printf(
                "Promedio de precios: %.2f%n",
                vehiculos.stream()
                        .mapToDouble(Vehiculo::getCosto)
                        .average()
                        .orElseThrow(() -> new RuntimeException("No se pudo calcular el promedio."))
        );


    }

    // Auxiliar para simplificar el código.
    private static String entradaVehiculoComoString(Map.Entry<Boolean, List<Vehiculo>> e) {
        String esMenorAMil = e.getKey() ? "Menores" : "Mayores o iguales";

        return "%s a 1000:\n%s"
                .formatted(
                        esMenorAMil,
                        e.getValue().stream()
                                .map(Vehiculo::getMarcaModelo)
                                .collect(joining(", "))
                );

    }

    private static List<Vehiculo> getVehiculos() {
        return List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corolla", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        );
    }
}
