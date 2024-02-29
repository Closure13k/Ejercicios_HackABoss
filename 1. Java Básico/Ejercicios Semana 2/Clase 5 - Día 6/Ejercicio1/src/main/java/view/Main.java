package view;

import model.Animal;
import model.Ave;
import model.Mamifero;
import model.Reptil;

/**
 * Crear una clase "Animal" con los atributos: id, nombre, edad, tipo de piel y tipo de alimentación
 * (con sus métodos y constructores correspondientes). Agregar también un método llamado saludar que
 * emita un mensaje por pantalla que diga “Hola, soy un animal”. A partir de esto hacer lo siguientes
 * pasos:<p>
 * a) Crear sus clases hijas que compartan sus atributos y métodos:
 * <ul><li>"Mamífero" con atributos adicionales: número de patas, tipo de reproducción, color de
 * pelaje, hábitat.</li>
 * <li>"Ave" con atributos adicionales: envergadura de alas, tipo de vuelo, color de plumaje, tipo de
 * pico.</li>
 * <li>"Reptil" con atributos adicionales: longitud, tipo de escamas, tipo de veneno, hábitat.</li></ul>
 * b)  Una vez creadas las clases, crear los siguientes métodos:
 * <ul><li>"Mamífero": sobrescribir el método saludar de la clase madre y colocar el mensaje "Hola, soy
 * un mamífero".</li>
 * <li>"Ave": sobrescribir el método saludar de la clase madre y colocar el mensaje "Hola, soy un ave".</li>
 * <li>"Reptil": sobrescribir el método saludar de la clase madre y colocar el mensaje "Hola, soy un reptil".</li></ul>
 * c) En el método "main", crear un objeto de cada clase hija. Llamar a los 3 métodos saludar desde cada
 * objeto.<p>
 * d) Crear un objeto de tipo animal e intentar asignarle al Mamifero creado… ¿Qué sucede? ¿Es posible
 * hacer esto? ¿Se aplica alguna propiedad para esto?<p>
 * e) Cambiar el modificador de acceso de los métodos de "public" a "private". Intentar acceder desde el
 * "main" a estos métodos. ¿Qué sucede? ¿Es posible hacer esto?
 */
public class Main {
    public static void main(String[] args) {
        Reptil reptil = new Reptil(1, "Manolo", 3, "Escamas", "Herbívoro", 2.23d, "Gruesas", "Neurotoxina", "Terrestre");
        Mamifero mamifero = new Mamifero(2, "Pepito", 5, "Pelo", "Omnívoro", 4, "Vivíparo", "Marrón", "Terrestre");
        Ave ave = new Ave(3, "Piolín", 1, "Plumas", "Omnívoro", 1.23d, "Planeo", "Amarillo", "Curvo");

        reptil.saludar();
        mamifero.saludar();
        ave.saludar();

        Animal animal   /* = new Animal(4, "Animal", 0, "Piel", "Omnívoro")*/;
        animal = mamifero; //Se puede hacer porque mamifero es un tipo de animal, es decir, hereda de animal.
        animal.saludar(); //Imprime "Hola, soy un mamífero".

        //Al cambiar el modificador de acceso de los métodos de "public" a "private" no se puede acceder a
        // ellos desde el "main". Se produce un error de compilación. Esto se debe a que los métodos privados
        // solo pueden ser accedidos desde la misma clase en la que se encuentran.
    }
}
