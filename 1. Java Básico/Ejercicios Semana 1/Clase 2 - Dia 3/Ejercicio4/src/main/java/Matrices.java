import javax.swing.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrices {
    //? Imagina que estás trabajando en un sistema de reservas de asientos para un teatro. Crea un programa en Java
    //? que represente un mapa de asientos en una matriz de 5x5 y ten en cuenta lo siguiente:
    //! - Los asientos pueden estar ocupados (representados por "X") o vacíos (representados por "O").
    //! - Permite al usuario ingresar por teclado donde quiere sentarse, indicando su fila y número
    //!   de asiento (por ejemplo, "Fila 3, Asiento 2"). El programa debe marcar como ocupado ese
    //!   asiento solo en caso de que esté vacío.
    //! - Si el asiento elegido por el usuario está ocupado, el sistema debe informar que elija otro diferente.
    //! - A medida que los asientos se ocupen, el programa debe actualizar el mapa de asientos y mostrarlo por
    //!   pantalla luego de cada reserva.
    //! - Intenta hacer pruebas con otros compañeros, imagina que ellos son los compradores y tú el encargado
    //!   del teatro. ¿Funciona para todos los casos? ¿Encontraste errores que resolver?
    //!   ¿Considera tu programa los asientos ya reservados?
    //! - El sistema deberá seguir corriendo hasta que el encargado de cargar las reservas de los asientos determine que ha finalizado.
    public static void main(String[] args) {
        int row, seat, rowInput = 0, seatInput = 0;
        char[][] seats = new char[5][5];
        Scanner scanner = new Scanner(System.in);

        //? Matriz poblada.
        Arrays.stream(seats).forEach(seatRow -> Arrays.fill(seatRow, 'O'));
        do {

            //? Output y recepción.
            printSeats(seats);
            System.out.println("Puede escribir -1 para finalizar el programa.");

            try {
                System.out.println("Elija la fila:");
                rowInput = scanner.nextInt();
                if (rowInput == -1) break;  //! Salida directa si así lo determina.
                System.out.println("Elija el asiento:");
                seatInput = scanner.nextInt();
                if (seatInput == -1) break; //! Salida directa si así lo determina.

            } catch (InputMismatchException ime) {
                //! ¿Funciona para todos los casos? ¿Encontraste errores que resolver?
                //? Recogemos la excepción en caso de caracteres raros.
                //? Se llama a nextLine para limpiar el scanner y lo hacemos continuar.
                System.err.println("Asegúrese de usar números, por favor. Valor introducido: " + scanner.nextLine());
                continue;
            }

            //! ¿Considera tu programa los asientos ya reservados?
            //? Validación y registro.
            if (isValidCoordinates(seats, rowInput, seatInput)) {
                row = rowInput - 1;
                seat = seatInput - 1;

                if (seats[row][seat] != 'X') {
                    seats[row][seat] = 'X';
                    System.out.printf("Reserva: Fila %d, asiento %d.\n", row, seat);
                } else {
                    System.out.printf("Asiento %d en fila %d está reservado.\n", row, seat);
                }

            } else {
                System.err.println("Número de fila o asiento no válido.");
            }
            //? Al tener break, esto será redundante.
        } while (true);

        //? Output final y liberamos recurso.
        System.err.println("Registro finalizado. Resultado final:");
        printSeats(seats);
        scanner.close();
    }

    /**
     * Por simplificar esa línea.
     */
    private static boolean isValidCoordinates(char[][] seats, int rowInput, int seatInput) {
        return rowInput > 0 && rowInput <= seats.length
                && seatInput > 0 && seatInput <= seats.length;
    }

    /**
     * Por simplificar el print.
     */
    private static void printSeats(char[][] seats) {
        System.out.println("---------------");
        Arrays.stream(seats).forEach(row -> System.out.println(Arrays.toString(row)));
        System.out.println("---------------");
    }
}
