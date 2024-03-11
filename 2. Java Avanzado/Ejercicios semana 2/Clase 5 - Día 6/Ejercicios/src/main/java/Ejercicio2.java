import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ejercicio2 {
    /**
     * Imagina que estás construyendo una aplicación para gestionar eventos en una agenda.
     * Cada evento tiene un nombre, una fecha y una categoría (por ejemplo, "Reunión", "Conferencia",
     * "Taller"). Implementa las siguientes operaciones utilizando Streams y Optionals:
     * <p>
     * Filtra los eventos que están programados para una fecha específica.
     * <p>
     * Agrupa los eventos por categoría y cuenta cuántos eventos hay en cada categoría.
     * <p>
     * Encuentra el evento más próximo en el tiempo utilizando Optionals.
     */

    public static void main(String[] args) {

        List<Evento> eventos = List.of(
                new Evento("Conferencia 1", LocalDate.of(2024, 2, 2), Categoria.CONFERENCIA),
                new Evento("Reunión 1", LocalDate.of(2024, 3, 1), Categoria.REUNION),
                new Evento("Taller 1", LocalDate.of(2024, 7, 3), Categoria.TALLER),
                new Evento("Reunión 2", LocalDate.of(2024, 7, 3), Categoria.REUNION),
                new Evento("Conferencia 2", LocalDate.of(2024, 10, 5), Categoria.CONFERENCIA)
        );

        // Filtra los eventos que están programados para una fecha específica.
        LocalDate fechaFiltrada = LocalDate.of(2021, 7, 3);
        Predicate<Evento> eventosEnFechaFiltrada = e -> e.getFecha().equals(fechaFiltrada);
        System.out.println("Eventos programados para el " + fechaFiltrada + ":");
        eventos.stream()
                .filter(eventosEnFechaFiltrada)
                .forEach(System.out::println);

        // Agrupa los eventos por categoría y cuenta cuántos eventos hay en cada categoría.
        System.out.println("\nCantidad de eventos por categoría:");
        eventos.stream()
                .collect(Collectors.groupingBy(
                        Evento::getCategoria,
                        Collectors.counting()
                ))
                .forEach((categoria, cantidad) -> System.out.println(categoria + ": " + cantidad));

        // Encuentra el evento más próximo en el tiempo utilizando Optionals.
        System.out.println("\nEvento más próximo en el tiempo:");
        eventos.stream()
                .filter(e -> e.getFecha().isAfter(LocalDate.now()))
                .min(Comparator.comparing(Evento::getFecha))
                .ifPresent(System.out::println);


    }

    private enum Categoria {
        REUNION, CONFERENCIA, TALLER
    }

    private static class Evento {

        private String nombre;
        private LocalDate fecha;
        private Categoria categoria;

        public Evento(String nombre, LocalDate fecha, Categoria categoria) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.categoria = categoria;
        }

        public Evento() {
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }

        @Override
        public String toString() {
            return "Evento{" +
                    "nombre='" + nombre + '\'' +
                    ", fecha=" + fecha +
                    ", categoria=" + categoria +
                    '}';
        }
    }
}
