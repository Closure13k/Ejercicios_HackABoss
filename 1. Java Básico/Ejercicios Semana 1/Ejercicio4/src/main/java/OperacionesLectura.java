import java.util.Scanner;

public class OperacionesLectura {
    //? Crea un programa que pida al usuario que ingrese por teclado dos números enteros y realice las siguientes
    //? operaciones con ellos: suma, resta, multiplicación y división. Muestra por pantalla/consola los resultados
    //? de cada una de las operaciones con un mensaje amigable para el usuario.
    //! ¿Qué sucede si como segundo número de una división se ingresa 0?
    //! Con lo que sabes o aprendiste hasta ahora… ¿De qué manera tratarías de evitar ésta situación?
    public static void main(String[] args) {
        int n1, n2;
        Scanner scanner = new Scanner(System.in);
        //? Recogida.
        System.out.println("Introduce el primer número:");
        n1 = scanner.nextInt();
        System.out.println("Introduce el segundo número:");
        n2 = scanner.nextInt();
        //? Operatoria.
        String mensajeConResultados = "Los resultados de ambos números (%d y %d) son:\n".formatted(n1, n2)
                + "Suma: %d + %d = %d\n".formatted(n1, n2, (n1 + n2))
                + "Resta: %d - %d = %d\n".formatted(n1, n2, (n1 - n2))
                + "Multiplicación: %d * %d = %d\n".formatted(n1, n2, (n1 * n2));
        //! ¿Qué sucede si como segundo número de una división se ingresa 0?
        //? Devuelve infinity porque n/0 es indefinido.
        //! Con lo que sabes o aprendiste hasta ahora… ¿De qué manera tratarías de evitar ésta situación?
        //? Se podría introducir un operador ternario (si x ? entonces x : sino y), if-else o interrumpir
        //? el flujo natural del programa de otro modo (p.ej. volviendo a pedir el dato).
        //? Opto por ternario.
        mensajeConResultados += n2 == 0
                ? "Un número dividido entre 0 devolverá indefinido :D"
                : "División: %d / %d = %.2f".formatted(n1, n2, ((double) n1 / (double) n2));

        System.out.println(mensajeConResultados);


    }
}
