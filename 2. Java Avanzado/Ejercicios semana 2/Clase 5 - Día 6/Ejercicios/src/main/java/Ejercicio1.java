import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ejercicio1 {
    /**
     * Crea una aplicación que maneje información sobre empleados. Cada empleado tiene un nombre,
     * un salario y una categoría (por ejemplo, "Desarrollador", "Analista", "Gerente"). Implementa
     * las siguientes operaciones utilizando Streams y Optionals:
     * <p>
     * Filtra los empleados cuyo salario sea mayor a cierto valor específico.
     * <p>
     * Agrupa los empleados por categoría y calcula el salario promedio para cada categoría.
     * <p>
     * Encuentra al empleado con el salario más alto utilizando Optionals.
     */

    public static void main(String[] args) {

        List<Empleado> empleados = List.of(
                new Empleado("Juan", 2000, Categoria.DESARROLLADOR),
                new Empleado("Pedro", 3000, Categoria.ANALISTA),
                new Empleado("Maria", 10000, Categoria.GERENTE),
                new Empleado("Jose", 5000, Categoria.DESARROLLADOR),
                new Empleado("Lucas", 6000, Categoria.ANALISTA)
        );

        // Filtra los empleados cuyo salario sea mayor a cierto valor específico.
        double salarioFiltrado = 4000;
        Predicate<Empleado> superaSalarioFiltrado = e -> e.getSalario() > salarioFiltrado;
        System.out.println("Empleados con salario mayor a " + salarioFiltrado + ":");
        empleados.stream()
                .filter(superaSalarioFiltrado)
                .forEach(System.out::println);

        // Agrupa los empleados por categoría y calcula el salario promedio para cada categoría.
        System.out.println("\nSalario promedio por categoría:");
        empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getCategoria,
                        Collectors.averagingDouble(Empleado::getSalario)
                ))
                .forEach((categoria, salarioPromedio) -> System.out.println(categoria + ": " + salarioPromedio));

        // Encuentra al empleado con el salario más alto utilizando Optionals.
        System.out.println("\nEmpleado con el salario más alto:");
        empleados.stream()
                .max(Comparator.comparing(Empleado::getSalario))
                .ifPresent(System.out::println);

    }

    private enum Categoria {
        DESARROLLADOR, ANALISTA, GERENTE
    }

    private static class Empleado {

        private String nombre;
        private double salario;
        private Categoria categoria;

        public Empleado(String nombre, double salario, Categoria categoria) {
            this.nombre = nombre;
            this.salario = salario;
            this.categoria = categoria;
        }

        public Empleado() {
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }

        @Override
        public String toString() {
            return "Empleado{" +
                    "nombre='" + nombre + '\'' +
                    ", salario=" + salario +
                    ", categoria=" + categoria +
                    '}';
        }
    }
}
