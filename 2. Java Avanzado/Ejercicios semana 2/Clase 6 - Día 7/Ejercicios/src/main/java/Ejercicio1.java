import auto.Auto;
import auto.InventarioAutos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio1 {
    /**
     * Una concesionaria de vehículos necesita un sistema para administrar su inventario de autos.
     * Crea una clase Auto con atributos como marca, modelo, año, y precio. Implementa una clase
     * utilitaria InventarioAutos con métodos genéricos para realizar las siguientes operaciones:
     * <p>
     * Agregar Autos al Inventario: Utiliza un método genérico para agregar autos al inventario
     * de la concesionaria.
     * <p>
     * Buscar Autos por Marca o Año: Implementa métodos genéricos que permitan buscar autos por
     * marca o año dentro del inventario.
     * <p>
     * Calcular el Valor Total del Inventario: Desarrolla un método genérico que calcule el valor
     * total de todos los autos en el inventario.
     */

    public static void main(String[] args) {
        InventarioAutos<Auto> inventarioAutos = new InventarioAutos<>(generateAutos());
        Auto auto = new Auto("Sear", "Mii", 2019, 10000);
        // Agregar auto al inventario
        Auto agregarAuto = inventarioAutos.agregarAuto(auto);
        System.out.println("Auto agregado: " + agregarAuto.getDetails());
        // Buscar autos por marca y sacamos por consola
        System.out.println("---------------------------\n" +
                "Autos por marca: Ferrari");
        inventarioAutos.buscarAuto("Ferrari")
                .forEach(a -> System.out.println(a.getDetails()));
        // Buscar autos por año y sacamos por consola
        System.out.println("---------------------------\n" +
                "Autos por año: 2021");
        inventarioAutos.buscarAuto(2021)
                .forEach(a -> System.out.println(a.getDetails()));
        // Calcular el valor total del inventario
        System.out.printf("---------------------------\n" +
                "Valor total del inventario: %,.2f€%n", inventarioAutos.calcularValorTotal());
    }


    private static List<Auto> generateAutos() {
        return new ArrayList<>(Arrays.asList(
                new Auto("Ferrari", "F8", 2021, 300000),
                new Auto("Lamborghini", "Huracan", 2022, 320000),
                new Auto("Porsche", "911", 2023, 250000),
                new Auto("BMW", "M5", 2021, 90000),
                new Auto("Mercedes-Benz", "AMG GT", 2022, 150000),
                new Auto("Audi", "R8", 2020, 200000),
                new Auto("Tesla", "Model S", 2023, 80000),
                new Auto("Ford", "Mustang", 2021, 50000),
                new Auto("Ford", "Focus", 2022, 35000),
                new Auto("Toyota", "Supra", 2023, 55000),
                new Auto("Toyota", "Corolla", 2021, 25000)
        ));
    }

}
