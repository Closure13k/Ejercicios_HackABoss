package models;

public class ExploradorDirectorio {
    public static String explorarDirectorio(Directorio directorio, int nivel) {
        StringBuilder sb = new StringBuilder();
        if (nivel == 0) {
            sb.append(directorio.getNombre()).append("/\n");
        }

        directorio.getSubdirectorios()
                .forEach(subdirectorio -> decoraDirectorio(nivel, subdirectorio, sb));
        directorio.getArchivos()
                .forEach(archivo -> decoraArchivo(nivel, archivo, sb));

        return sb.toString();
    }

    private static void decoraDirectorio(int nivel, Directorio subdirectorio, StringBuilder sb) {
        sb.append("  |  ".repeat(nivel))
                .append("  +- ")
                .append("%s/".formatted(subdirectorio.getNombre()))
                .append("\n")
                .append(explorarDirectorio(subdirectorio, nivel + 1));
    }

    private static void decoraArchivo(int nivel, String archivo, StringBuilder sb) {
        sb.append("  |  ".repeat(nivel)).append("  x- ").append("/%s".formatted(archivo)).append("\n");
    }
}
