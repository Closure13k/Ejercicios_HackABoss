/**
 * Imagina que estás desarrollando un sistema de gestión de inventarios para un comercio minorista.
 * Los usuarios pueden agregar productos al inventario proporcionando información como el nombre
 * del producto, el precio y la cantidad disponible. Tu tarea es implementar una función que maneje
 * la gestión de inventarios, validando los datos ingresados y manejando excepciones en caso de
 * errores o datos inválidos.
 * <p>
 * Trata de ser lo más descriptivo posible en cada mensaje de excepción (en caso de que ésta sea
 * opersonalizada) o de utilizar los tipos correctos de excepción en cada caso.
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        //Probamos el método con diferentes casos
        try {
            addProduct("", 100, 10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {

            addProduct("Producto 2", 0, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            addProduct("Producto 3", 100, -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addProduct(String name, double price, int quantity) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("El precio del producto debe ser mayor a 0");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("La cantidad del producto debe ser mayor o igual a 0");
        }
        System.out.println("Producto agregado: " + name + " - " + price + " - " + quantity);
    }

}
