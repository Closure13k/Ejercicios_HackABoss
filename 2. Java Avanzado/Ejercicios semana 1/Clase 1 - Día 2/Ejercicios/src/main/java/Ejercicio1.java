import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/**
 * Imagina que estás desarrollando un sistema de reservas de vuelos para una aerolínea. Los usuarios
 * pueden realizar reservas de vuelos proporcionando información como su nombre, destino, fecha de
 * viaje y número de asientos deseados. Tu tarea es implementar una función de reserva de vuelos
 * que valide los datos ingresados y maneje excepciones si los datos son incorrectos o si no hay
 * suficientes asientos disponibles en el vuelo.
 * <p>
 * Debes crear una excepción personalizada, por ejemplo, ReservaInvalidaException, que se lance en
 * situaciones excepcionales, como cuando un usuario intenta reservar más asientos de los disponibles
 * o si falta información esencial. La excepción personalizada debe proporcionar un mensaje claro
 * sobre la causa del error.
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Reserva reserva = new Reserva();
        System.out.println("Ingrese su nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese su destino: ");
        String destino = input.nextLine();
        System.out.println("Ingrese la fecha de viaje: ");
        String fecha = input.nextLine();
        System.out.println("Ingrese el número de asientos deseados: ");
        int asientos = input.nextInt();
        try {
            reserva = reservarVuelo(nombre, destino, fecha, asientos);
            System.out.println("Reserva exitosa" + reserva.getNombre());
        } catch (ReservaInvalidaException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Reserva reservarVuelo(String nombre, String destino, String fecha, int asientos) throws ReservaInvalidaException {
        if (nombre.isBlank()) {
            throw new ReservaInvalidaException("El nombre no puede estar vacío");
        }
        if (destino.isBlank()) {
            throw new ReservaInvalidaException("El destino no puede estar vacío");
        }
        LocalDate date;
        try {
            DateTimeFormatter strictDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    .withResolverStyle(ResolverStyle.STRICT);
            date = LocalDate.parse(fecha, strictDateFormat);
        } catch (DateTimeParseException e) {
            throw new ReservaInvalidaException("La fecha no es válida. El formato debe ser dd/mm/aaaa y una fecha real.");
        }

        if (asientos <= 0) {
            throw new ReservaInvalidaException("El número de asientos debe ser mayor a 0");
        }

        return new Reserva(nombre, destino, date, asientos);
    }


    public static class ReservaInvalidaException extends Exception {
        public ReservaInvalidaException(String message) {
            super(message);
        }
    }

    public static class Reserva {
        private String nombre;
        private String destino;
        private LocalDate fecha;
        private int asientos;

        public Reserva(String nombre, String destino, LocalDate fecha, int asientos) {
            this.nombre = nombre;
            this.destino = destino;
            this.fecha = fecha;
            this.asientos = asientos;
        }

        public Reserva() {
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDestino() {
            return destino;
        }

        public void setDestino(String destino) {
            this.destino = destino;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public int getAsientos() {
            return asientos;
        }

        public void setAsientos(int asientos) {
            this.asientos = asientos;
        }

        @Override
        public String toString() {
            return "Reserva{" +
                    "nombre='" + nombre + '\'' +
                    ", destino='" + destino + '\'' +
                    ", fecha=" + fecha +
                    ", asientos=" + asientos +
                    '}';
        }
    }
}
