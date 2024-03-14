import models.ej1.*;

import java.util.Comparator;

public class EjerciciosClase2 {
    /**
     * Ejercicio Nº 5: Streams y Optionals
     * Sobre el ejercicio 3 (inventario con generics), implementa las siguientes
     * operaciones utilizando Streams y Optionals:
     * 1.	Filtrar los productos electrónicos de una marca determinada y
     * mostrarlos.
     * 2.	Sobre los productos electrónicos filtrados, obtener el precio
     * MAXIMO y mostrarlo.
     */
    public static void main(String[] args) {
        // Crear inventario para electrónicos
        Inventario<Electronico> inventarioElectronico = new Inventario<>();
        inventarioElectronico.agregarProducto(new Electronico("Laptop", 1200.0, "MarcaX"));
        inventarioElectronico.agregarProducto(new Electronico("Smartphone", 800.0, "MarcaY"));

        // Crear inventario para ropa
        Inventario<Ropa> inventarioRopa = new Inventario<>();
        inventarioRopa.agregarProducto(new Ropa("Camiseta", 20.0, "M", "Algodón"));
        inventarioRopa.agregarProducto(new Ropa("Jeans", 50.0, "32", "Denim"));

        // Crear inventario para libros
        Inventario<Libro> inventarioLibros = new Inventario<>();
        inventarioLibros.agregarProducto(new Libro("Java 101", 29.99, "John Doe"));
        inventarioLibros.agregarProducto(new Libro("Historia del Arte", 39.99, "Jane Smith"));

        // Filtrar los productos electrónicos de una marca determinada y mostrarlos.
        inventarioElectronico.getProductos()
                .stream()
                .filter(electronico -> electronico.getMarca().equalsIgnoreCase("MarcaX"))
                .forEach(System.out::println);

        // Sobre los productos electrónicos filtrados, obtener el precio MAXIMO y mostrarlo.
        inventarioElectronico.getProductos()
                .stream()
                .max(Comparator.comparingDouble(Producto::getPrecio))
                .ifPresent(electronico -> System.out.println("Precio máximo: " + electronico.getNombre() + " - " + electronico.getPrecio()));

    }


}
