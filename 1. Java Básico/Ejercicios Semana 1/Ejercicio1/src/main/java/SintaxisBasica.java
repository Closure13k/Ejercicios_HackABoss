public class SintaxisBasica {
    //? a) Escribir un programa en Java que muestre por pantalla un mensaje de Bienvenida a un usuario.
    //! Por ejemplo: “Hola, bienvenido al sistema”.
    //? b) Una vez logrado esta primera parte, permitir que se almacene el nombre del usuario en una
    //? variable y se muestre el mismo en el mensaje. Por ejemplo: “Hola Eduardo, bienvenida al sistema”.
    public static void main(String[] args) {
        String name = "Aaron";
        //! Apartado a.
        System.out.println("Hola, bienvenido al sistema.");
        //! Apartado b.
        System.out.println("Hola " + name + ", bienvenido al sistema.");
    }
}
