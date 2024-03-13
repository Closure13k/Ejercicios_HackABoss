package models;

import java.util.List;

public class ExploradorTareas {
    public static String mostrarTareas(Tarea tarea, int nivel) {
        StringBuilder sb = new StringBuilder();
        if (nivel == 0) {
            sb.append(tarea.getIdNombre()).append("\n");
        }
        List<Tarea> subtareas = tarea.getSubtareas();
        for (int i = 0; i < subtareas.size(); i++) {
            boolean esUltimaEntrada = i == subtareas.size() - 1;
            Tarea subtarea = subtareas.get(i);
            sb.append(" |  ".repeat(nivel))
                    .append(esUltimaEntrada ? " └─ " : " ├─ ")
                    .append(subtarea.getIdNombre())
                    .append("\n");
            sb.append(mostrarTareas(subtarea, nivel + 1));
        }

        return sb.toString();
    }

    public static Tarea buscarTarea(Tarea proyecto, int idPadre) {
        if (proyecto.getId() == idPadre) {
            return proyecto;
        }
        List<Tarea> subtareas = proyecto.getSubtareas();
        for (Tarea subtarea : subtareas) {
            Tarea resultado = buscarTarea(subtarea, idPadre);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }
}
