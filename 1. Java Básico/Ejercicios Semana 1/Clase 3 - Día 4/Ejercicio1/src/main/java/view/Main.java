package view;

import model.Electrodomestico;

public class Main {
    //? a) Crea 3 objetos de la clase Electrodomestico utilizando parámetros.
    //? b) Crea 1 objeto de la clase Electrodomestico sin parámetros.
    //? c) Muestra por pantalla la marca, modelo y consumo energético de los 3 electrodomésticos creados con parámetros.
    //? d) Intenta obtener la marca del electrodoméstico creado sin parámetros.
    //! ¿Se obtiene algún valor? De ser así… ¿Qué valor se obtiene?
    public static void main(String[] args) {
        //! a) Crea 3 objetos de la clase Electrodomestico utilizando parámetros.
        Electrodomestico appliance1 = new Electrodomestico("Cod1", "Marca1", "Modelo1", "A", "Rojo");
        Electrodomestico appliance2 = new Electrodomestico("Cod2", "Marca2", "Modelo2", "E", "Azul");
        Electrodomestico appliance3 = new Electrodomestico("Cod3", "Marca3", "Modelo3", "C", "Blanco");
        //! b) Crea 1 objeto de la clase Electrodomestico sin parámetros.
        Electrodomestico noParamAppliance = new Electrodomestico();

        //! c) Muestra por pantalla la marca, modelo y consumo energético de los 3 creados con parámetros.
        System.out.printf(
                "Creados con parámetros:\n%s, %s - %s\n%s, %s - %s\n%s, %s - %s\n",
                appliance1.getMarca(), appliance1.getModelo(), appliance1.getConsumo(),
                appliance2.getMarca(), appliance2.getModelo(), appliance2.getConsumo(),
                appliance3.getMarca(), appliance3.getModelo(), appliance3.getConsumo()
        );
        //! d) Intenta obtener la marca del electrodoméstico creado sin parámetros.
        System.out.println(noParamAppliance.getMarca());
        //! ¿Se obtiene algún valor? De ser así… ¿Qué valor se obtiene?
        //? Se obtiene una representación de valor nulo al ser cadena. En caso de ser tipo de dato sería excepción.

    }
}
