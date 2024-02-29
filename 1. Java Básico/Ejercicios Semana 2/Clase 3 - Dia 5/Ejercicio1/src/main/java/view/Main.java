package view;

import model.Verdura;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * a) Crear un vector (array) de tipo Verdura que pueda almacenar 5 verduras. Crear 5 verduras y
 * guardarlas en el vector.<p>
 * b) Recorrer el vector creado y mostrar por pantalla el nombre y las calorías de las verduras
 * almacenadas.<p>
 * c) Cambiar todos los datos de dos verduras. Mostrar por pantalla los datos de todas las
 * verduras luego del cambio.<p>
 * d) Recorrer el vector y mostrar por pantalla únicamente a las verduras que sean de color
 * verde.
 */
public class Main {
    public static void main(String[] args) {
        //Array de tipo Verdura con capacidad 5 y llenado. Con stream por practicar.
        Verdura[] verduras = IntStream.range(0, 5)
                .mapToObj(i -> new Verdura(i, (i % 2 == 0 ? "Espinacas " : "Pimientos ") + (i + 1), i % 2 == 0 ? "Verde" : "Rojo", 125))
                .toArray(Verdura[]::new);
        //Recorrer el array creado y mostrar nombre y calorías.
        System.out.println("## Todas las verduras:\n" + collectVeggiesToString(Arrays.stream(verduras)));
        //Cambiar los datos de dos verduras: p.ej. 2 y 4.
        updateTwoVeggies(verduras);
        //Volvemos a mostrarlo.
        System.out.println("## Verduras tras actualización:\n" + collectVeggiesToString(Arrays.stream(verduras)));
        //Recorrer y mostrar únicamente las que sean de color verde.
        System.out.println("## Verduras filtradas:\n" + collectVeggiesToString(getVeggiesByColour(verduras, "verde")));
    }


    /**
     * Convierte el contenido del array verduras en una cadena de texto, mostrando únicamente
     * el nombre y las calorías.
     *
     * @param verduraStream El stream a convertir.
     * @return La información del array en una cadena.
     */
    private static String collectVeggiesToString(Stream<Verdura> verduraStream) {
        return verduraStream
                .map(v -> v.getNombre() + ": " + v.getCalorias())
                .collect(Collectors.joining("\n"));
    }

    /**
     * Filtra el stream de verduras y lo devuelve para su posterior terminación.
     *
     * @param verduras El array de verduras
     * @param colour   El color a filtrar.
     * @return El resultado de dicho filtrado para su uso terminal (en su caso,
     * ser recogido por {@link #collectVeggiesToString(Stream)}.
     */
    public static Stream<Verdura> getVeggiesByColour(Verdura[] verduras, String colour) {
        return Arrays.stream(verduras).filter(
                verdura -> verdura.getColor().toLowerCase().contains(colour));
    }

    /**
     * Cambia los datos de dos objetos Verdura.
     *
     * @param verduras El array a acceder.
     */
    private static void updateTwoVeggies(Verdura[] verduras) {
        verduras[1].setId(125);
        verduras[1].setNombre("Patacas");
        verduras[1].setCalorias(1200);
        verduras[1].setColor("Marrón");
        verduras[3].setId(250);
        verduras[3].setNombre("Pepino");
        verduras[3].setCalorias(300);
        verduras[3].setColor("Mal color...");
    }
}
