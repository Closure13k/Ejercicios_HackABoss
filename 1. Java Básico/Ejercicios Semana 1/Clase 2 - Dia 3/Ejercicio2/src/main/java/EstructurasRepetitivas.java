import java.util.Scanner;

public class EstructurasRepetitivas {
    //? Imagina que eres un cajero en un supermercado. Crea un programa en Java que permita ingresar el
    //? precio de varios productos comprados por un cliente.
    //? Utiliza una estructura repetitiva (la que quieras) para continuar pidiendo precios hasta que el
    //? usuario decida finalizar. Luego, muestra el total de la compra que debe abonar.
    public static void main(String[] args) {
        double price = 0, total = 0;
        String message = "";
        Scanner scanner = new Scanner(System.in);

        do {
            if (price >= 0) {
                message = "Total: %.2f €\n".formatted(total);
            }

            System.out.println(message + "Por favor, ingrese un precio (un valor negativo terminará el programa):");
            price = scanner.nextDouble();
            total = price > 0 ? total + price : total;
        } while (!(price < 0));

        System.out.printf("Proceda con el pago.\nCoste total: %.2f €", total);
    }
}
