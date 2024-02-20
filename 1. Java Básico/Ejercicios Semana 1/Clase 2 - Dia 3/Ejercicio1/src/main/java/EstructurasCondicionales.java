import java.util.Scanner;

public class EstructurasCondicionales {
    //? Una recital permite únicamente el ingreso de mayores de 18 años. Para ello necesita un programa que,
    //? a partir de que un usuario ingrese su edad, determine mediante un mensaje en pantalla si la persona
    //? puede o no ingresar al evento. El programa debe mostrar (según cada caso) un mensaje informando
    //? la situación.
    public static void main(String[] args) {
        int age;
        String message;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su edad:");
        age = scanner.nextInt();

        message = "Edad: %d\n".formatted(age);

        if (age < 0 || age > 125) {
            message += "Por favor, ingrese una edad válida.";
        } else if (age < 18) {
            message += "Disculpe. Sólo se permite el ingreso a mayores de 18 años.";
        } else {
            message += "Bienvenido!";
        }

        System.out.println(message);
    }
}
