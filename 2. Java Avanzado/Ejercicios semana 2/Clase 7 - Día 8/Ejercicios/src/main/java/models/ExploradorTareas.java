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

    public static Tarea buscarTarea(Tarea tarea, int idPadre) {
        if (tarea.getId() == idPadre) {
            return tarea;
        }
        for (Tarea subtarea : tarea.getSubtareas()) {
            Tarea resultado = buscarTarea(subtarea, idPadre);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }
}
