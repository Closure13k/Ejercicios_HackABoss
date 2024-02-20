public class VariablesOperadores {
    //? Escribe un programa que permita calcular el área de un triángulo y luego mostrar el resultado por pantalla.
    //? Recuerda que la fórmula para calcular esto es:
    //! (base * altura) / 2 (base por altura dividido dos).
    public static void main(String[] args) {
        double base = 5, height = 10, area = ((base * height) / 2);
        
        System.out.printf("El área de un triángulo de base %.2f y altura %.2f es %.2f", base, height, area);
    }
}
