package com.closure13k.clase5dia6.controller;

import com.closure13k.clase5dia6.dto.GradeDTO;
import com.closure13k.clase5dia6.dto.StudentDTO;
import com.closure13k.clase5dia6.service.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/programacion")
public class GradeController {
    private final GradeService gradeService;
    
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }
    
    @GetMapping("/estudiantes")
    public ResponseEntity<List<StudentDTO>> getStudents() {
        List<StudentDTO> studentDTOS = gradeService.getAllStudents()
                .stream().map(StudentDTO::fromStudent)
                .toList();
        return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
    }
    
    @GetMapping("/calificaciones/{matricula}")
    public ResponseEntity<GradeDTO> getCalificaciones(@PathVariable String matricula) {
        GradeDTO gradeDTO = gradeService.getGradeByStudent(matricula)
                .map(GradeDTO::fromStudentWithGrades)
                .orElse(GradeDTO.empty());
        return new ResponseEntity<>(gradeDTO, HttpStatus.OK);
    }
    
    @GetMapping("/calificaciones/ordendesc")
    public ResponseEntity<List<GradeDTO>> getCalificacionesOrdenDesc() {
        List<GradeDTO> gradeDTOS = gradeService.getAllGradesSortedByAverage()
                .stream()
                .map(GradeDTO::fromStudentWithGrades)
                .toList();
        return new ResponseEntity<>(gradeDTOS, HttpStatus.OK);
    }
    
}
/*
    Crear una API que gestione los datos de estudiantes de una universidad y que devuelva una lista ordenada de
    acuerdo con su rendimiento académico en la materia “Programación I” (calculado en forma de promedio).
    
    Implementar para esto una arquitectura de múltiples capas, destacando la capa service, para procesar y
    analizar los datos de los estudiantes.
    
    Enfocarse en la lógica de negocio para evaluar el rendimiento académico, pudiendo involucrar la capa
    model para representar los datos de los estudiantes.
    
    De cada estudiante se solicitan los siguientes datos: num_matricula, nombre, apellido, fecha de nacimiento.
    
    Para las calificaciones se necesita una clase Grade, la cual almacena las 3 calificaciones que
    obtuvo cada estudiante en los examenes de la materia “Programación I” y su promedio. Tener en cuenta
    que cada estudiante tiene uno y solo un registro de calificaciones asociado.
    
    En la clase calificación se debe guardar: id, calificacion1, calificacion2, calificacion3, promedio,
    Alumno un Alumno.
    
    En la capa controller deberán existir los siguientes endpoints:
    
    GET /estudiantes: Devuelve una lista de todos los estudiantes sin un orden particular.
    
    GET /calificaciones/{num_matricula}: Devuelve las calificaciones de un determinado estudiante.
    
    GET /calificaciones/ordendesc: Devuelve las calificaciones de todos los estudiantes, junto con el
    nombre de cada uno de ellos ordenados de forma descendente (mayor calificación primero, menor a
    lo último)
 */