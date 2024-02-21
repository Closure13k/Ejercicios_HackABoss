package view;

import model.Persona;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    //? a) Crear un vector de tipo Persona cinco posiciones. Crear cinco personas y guardarlas en él.
    //? b) Recorrer el vector creado y mostrar por pantalla el nombre y edad de cada persona almacenada.
    //? c) Cambiar el nombre de dos personas. Mostrar por pantalla el antes, realizar el cambio y luego mostrar el después de los datos de las dos personas cuyos nombres fueron cambiados.
    //? d) Recorrer el vector y mostrar por pantalla únicamente a las personas cuya edad sea mayor de 30 año
    public static void main(String[] args) {
        Persona[] people = new Persona[5];
        //! a) Crear un vector de tipo Persona cinco posiciones. Crear cinco personas y guardarlas en él.
        IntStream.range(0, people.length)
                .forEach(i -> {
                    int j = i + 1;
                    people[i] = new Persona(j, "Persona" + j, 28 + j, "Direccion " + j, "98112345" + j);
                });
        //! b) Recorrer el vector creado y mostrar por pantalla el nombre y edad de cada persona almacenada.
        String message = Arrays.stream(people)
                .map(persona -> persona.getNombre() + " " + persona.getEdad())
                .collect(Collectors.joining("\n"));

        System.out.println(message);

        //! c) Cambiar el nombre de dos personas. Mostrar por pantalla el antes, realizar el cambio y
        //! luego mostrar el después de los datos de las dos personas cuyos nombres fueron cambiados.
        System.out.println("Antes: " + people[1].getNombre() + ", " + people[3].getNombre());
        people[1].setNombre("Manolo");
        people[3].setNombre("Julio");
        System.out.println("Después: " + people[1].getNombre() + ", " + people[3].getNombre());

        //! d) Recorrer el vector y mostrar por pantalla únicamente a las personas cuya edad sea mayor de 30 año
        message = Arrays.stream(people)
                .filter(persona -> persona.getEdad() > 30)
                .map(persona -> persona.getNombre() + " " + persona.getEdad())
                .collect(Collectors.joining("\n"));

        System.out.println(message);

    }
}
