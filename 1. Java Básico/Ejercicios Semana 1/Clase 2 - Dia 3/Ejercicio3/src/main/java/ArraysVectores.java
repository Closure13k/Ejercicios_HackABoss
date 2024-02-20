import java.util.Arrays;
import java.util.Scanner;

public class ArraysVectores {
    //? Una web de meteorología necesita de un programa que, al ingresar las 7 temperaturas máximas
    //? de la última semana, calcule la temperatura máxima promedio que hubo.
    //? Para ello, deberá manejar un vector donde en cada posición se almacene la correspondiente
    //? temperatura máxima de cada día. Una vez almacenadas las temperaturas, deberá calcular el
    //? promedio de las mismas recorriendo el vector y mostrando el resultado por pantalla.
    public static void main(String[] args) {
        double[] temperatures = new double[7];
        double average = 0;
        String message;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < temperatures.length; i++) {
            System.out.println("Introduzca la temperatura máxima:");
            temperatures[i] = scanner.nextDouble();
        }
        //! Con streams.
        average = Arrays.stream(temperatures).average().orElseThrow();
        message = "El promedio para las temperaturas %s es %.2f".formatted(Arrays.toString(temperatures), average);
        System.out.println(message);
        //! Con bucle.
        //! En este caso reutilizo la propia variable "promedio". Queda comentado.
        /*
        for (double temperature : temperatures) {
            average += temperature;
        }
        */
//        average /= temperatures.length;
    }
}
