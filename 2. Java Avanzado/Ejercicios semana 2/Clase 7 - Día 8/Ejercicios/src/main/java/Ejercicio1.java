import models.Directorio;
import models.ExploradorDirectorio;

public class Ejercicio1 {
    /**
     * Crea un programa que simule la exploración recursiva de directorios en el sistema de
     * archivos de un sistema operativo utilizando una estructura de datos propia.
     * <p>
     * Emplea una estructura donde cada nodo representa un directorio y contiene referencias
     * a sus subdirectorios.
     * <p>
     * El programa debe realizar una exploración simulada para mostrar la jerarquía de
     * directorios y archivos.
     * <p>
     * Pistas:
     * <p>
     * Puedes utilizar una clase Directorio para cada una de las carpetas/directorios que
     * contenga como datos: id, nombre, listaSubdirectorios, listaArchivos
     */
    public static void main(String[] args) {
        Directorio raiz = new Directorio(1, "Documentos");
        cargarDirectorio(raiz);
        System.out.println(ExploradorDirectorio.explorarDirectorio(raiz, 0));
    }

    private static void cargarDirectorio(Directorio raiz) {
        // Agregar archivos a la raíz
        raiz.getArchivos().add("archivo_raiz1.txt");
        raiz.getArchivos().add("archivo_raiz2.txt");

        // Crear subdirectorios
        Directorio subDir1 = new Directorio(2, "SubDirectorio1");
        Directorio subDir2 = new Directorio(3, "SubDirectorio2");
        Directorio subDir3 = new Directorio(4, "SubDirectorio3");

        // Agregar archivos a los subdirectorios
        subDir1.getArchivos().add("archivo_subdir1.txt");
        subDir2.getArchivos().add("archivo_subdir2.txt");
        subDir3.getArchivos().add("archivo_subdir3.txt");

        // Crear sub subdirectorios
        Directorio subSubDir1 = new Directorio(5, "SubSubDirectorio1");
        Directorio subSubDir2 = new Directorio(6, "SubSubDirectorio2");
        Directorio subSubDir3 = new Directorio(7, "SubSubDirectorio3");

        // Agregar archivos a los sub subdirectorios
        subSubDir1.getArchivos().add("archivo_subsubdir1.txt");
        subSubDir2.getArchivos().add("archivo_subsubdir2.txt");
        subSubDir3.getArchivos().add("archivo_subsubdir3.txt");

        // Agregar sub subdirectorios a los subdirectorios
        subDir1.getSubdirectorios().add(subSubDir1);
        subDir2.getSubdirectorios().add(subSubDir2);
        subDir3.getSubdirectorios().add(subSubDir3);

        // Agregar subdirectorios a la raíz
        raiz.getSubdirectorios().add(subDir1);
        raiz.getSubdirectorios().add(subDir2);
        raiz.getSubdirectorios().add(subDir3);
    }
}
