/**
 * Estás desarrollando una aplicación de gestión de datos en la que puedes almacenar información
 * en un vector y acceder a ella posteriormente. Tu tarea es implementar una función que te permita
 * almacenar datos en un vector y manejar excepciones estándar de Java teniendo en cuenta lo siguiente:
 * <p>
 * Desarrolla una función que te permita almacenar datos en un vector. Puedes utilizar un vector de
 * tamaño fijo para simplificar el ejercicio.
 * <p>
 * Luego, implementa un mecanismo que te permita acceder a los datos almacenados en el vector
 * proporcionando un índice.
 * <p>
 * Utiliza una excepción estándar de Java que, al intentar acceder a una posición que no existe en
 * el vector, por ejemplo, un índice que esté fuera del rango del vector se pueda capturar.
 * <p>
 * Captura la excepción y proporciona un mensaje de error descriptivo que indique que estás intentando
 * acceder a una posición inválida en el vector.
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        String[] vector = new String[5];
        try {
            addDato(vector, 0, "Dato 1");
            addDato(vector, 1, "Dato 2");
            addDato(vector, 2, "Dato 3");
            addDato(vector, 3, "Dato 4");
            addDato(vector, 4, "Dato 5");
            addDato(vector, 5, "Dato 6");   // Aquí se lanza la excepción
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            readDato(vector, 0);
            readDato(vector, 1);
            readDato(vector, 2);
            readDato(vector, 3);
            readDato(vector, 4);
            readDato(vector, 5); // Aquí se lanza la excepción
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }

    }

    private static void readDato(String[] vector, int i) {
        try {
            System.out.println("Dato en la posición " + i + ": " + vector[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(exceptionMessage(vector, i));
        }
    }

    private static void addDato(String[] vector, int i, String s) {
        try {
            vector[i] = s;
            System.out.println("Dato agregado: " + s + " en la posición " + (i + 1));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(
                    exceptionMessage(vector, i));
        }
    }

    private static String exceptionMessage(String[] vector, int i) {
        return "Estás intentando acceder a una posición inválida en el vector. El tamaño del vector es de "
                + vector.length + " posiciones. Tú estás intentando acceder a la posición " + (i + 1);
    }

}
