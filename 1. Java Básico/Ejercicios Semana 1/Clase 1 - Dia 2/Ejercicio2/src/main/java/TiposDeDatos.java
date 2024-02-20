public class TiposDeDatos {
    //? a) Crea un programa que declare una variable para cada uno de los siguientes tipos de datos:
    //! int, double, boolean y String. Asigna un valor a cada variable y muestra su contenido en la consola.
    //? b) Ahora, asigna valores que no correspondan al tipo de dato. Por ejemplo, un int en un String o un
    //? String en un double… ¿Qué sucede con el programa? ¿Se produce algún error? ¿En qué situaciones se
    //? genera error y en cuáles no? Justificar el porqué de cada caso. Debatir con otros compañeros.
    public static void main(String[] args) {
        //! Apartado a.
        int integerNumber = 1;
        double doublePrecision = 1.32d;
        boolean trueOrFalse = true;
        String myName = "Aaron";

        System.out.println("Tipos de datos primitivos y un String.\n----------");
        System.out
                .printf("Integer: %d\n", integerNumber)
                .printf("Esto es un double: %f\n", doublePrecision)
                .printf("Esto es un boolean: %s\n", trueOrFalse)
                .printf("Esto es un String: %s", myName);
        //! Apartado b.
        integerNumber = 'k'; //? Devolverá el número 107 por println. https://en.wikipedia.org/wiki/K#Computing_codes
        //? Si usamos una cadena de texto o un booleano, salta un error en compilación.

        doublePrecision = -1;//? Si bien podría pasar por un entero, este sigue manteniendo su tipo como flotante de precisión doble.

        //! En estos casos de errores de compilación, el programa no se ejecutaría.
        //? Por comodidad, se comentan las siguientes líneas.
        //trueOrFalse = 1;
        //myName = 1;
    }
}
