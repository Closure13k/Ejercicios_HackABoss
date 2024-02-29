package view;

import model.*;

import java.util.Arrays;

/**
 * Crear una clase llamada Vestimenta con los atributos: código, nombre, precio, marca, talla y
 * color (con sus métodos y constructores correspondientes).<p>
 * a) Crear las siguientes clases hijas que compartan sus atributos y métodos:
 * <ul>
 * <li>Zapato: material, tipoCierre</li>
 * <li>Pantalon: estilo, tipoTejido</li>
 * <li>Camiseta: manga, cuello </li>
 * <li>Sombrero: tipo, tamaño</li>
 * </ul>
 * b) Una vez creadas las clases, crear en el Main un vector de tipo Vestimenta y almacenar 3
 * zapatos, 3 pantalones, 2 camisetas y 1 sombrero (crear un objeto con parámetros para cada
 * uno de ellos).<p>
 * c) Crear los siguientes métodos (en cada subclase correspondiente):
 * <ul>
 * <li>Zapato: método para mostrar un mensaje en pantalla que diga "Estos zapatos son de marca: "
 * (mostrar marca).</li>
 * <li>Pantalon: método para mostrar un mensaje en pantalla que diga "Estos pantalones son de marca: "
 * (mostrar estilo).</li>
 * <li>Camiseta: método para mostrar un mensaje en pantalla que diga "Esta camiseta es de marca: "
 * (mostrar manga).</li>
 * <li>Sombrero: método para mostrar un mensaje en pantalla que diga "Este sombrero es de marca: "
 * (mostrar tipo).</li>
 * </ul>
 * d) Recorrer el vector y ejecutar el método que corresponde en cada posición del mismo.
 */
public class Main {
    public static void main(String[] args) {
        Vestimenta[] vestimentas = new Vestimenta[9];
        vestimentas[0] = new Zapato(1, "Zapato 1", 100, "Marca 1", "Talla 1", "Color 1", "Material 1", "Tipo Cierre 1");
        vestimentas[1] = new Zapato(2, "Zapato 2", 200, "Marca 2", "Talla 2", "Color 2", "Material 2", "Tipo Cierre 2");
        vestimentas[2] = new Zapato(3, "Zapato 3", 300, "Marca 3", "Talla 3", "Color 3", "Material 3", "Tipo Cierre 3");
        vestimentas[3] = new Pantalon(4, "Pantalon 1", 400, "Marca 4", "Talla 4", "Color 4", "Estilo 1", "Tipo Tejido 1");
        vestimentas[4] = new Pantalon(5, "Pantalon 2", 500, "Marca 5", "Talla 5", "Color 5", "Estilo 2", "Tipo Tejido 2");
        vestimentas[5] = new Pantalon(6, "Pantalon 3", 600, "Marca 6", "Talla 6", "Color 6", "Estilo 3", "Tipo Tejido 3");
        vestimentas[6] = new Camiseta(7, "Camiseta 1", 700, "Marca 7", "Talla 7", "Color 7", "Manga 1", "Cuello 1");
        vestimentas[7] = new Camiseta(8, "Camiseta 2", 800, "Marca 8", "Talla 8", "Color 8", "Manga 2", "Cuello 2");
        vestimentas[8] = new Sombrero(9, "Sombrero 1", 900, "Marca 9", "Talla 9", "Color 9", "Tipo 1", "Tamaño 1");

        Arrays.stream(vestimentas).forEach(Vestimenta::mostrarMensaje);
    }
}
