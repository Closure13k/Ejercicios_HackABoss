package com.closure13k.clase5dia6.dto;

import com.closure13k.clase5dia6.model.Grade;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GradeDTO {
    private final String id;
    private Double grade1;
    private Double grade2;
    private Double grade3;
    private Double average;
    private String studentId;
    private String studentName;
    
    /**
     * Devuelve un GradeDTO a partir de un Grade oculta el id del estudiante.
     *
     * @param grade Grade a convertir.
     * @return GradeDTO con los datos del Grade.
     */
    public static GradeDTO fromStudentWithGrades(Grade grade) {
        return GradeDTO.builder()
                .withStudentName(grade.getStudent().getName())
                .withGrade1(grade.getGrade1())
                .withGrade2(grade.getGrade2())
                .withGrade3(grade.getGrade3())
                .withAverage(grade.getAverage())
                .build();
    }
    
    /**
     * Devuelve un GradeDTO vacío para indicar que no se encontró el Grade.
     *
     * @return GradeDTO vacío.
     */
    public static GradeDTO empty() {
        return GradeDTO.builder()
                .withId("No encontrado")
                .build();
    }
}