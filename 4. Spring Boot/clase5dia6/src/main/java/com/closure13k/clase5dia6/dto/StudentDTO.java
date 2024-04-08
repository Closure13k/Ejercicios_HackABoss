package com.closure13k.clase5dia6.dto;

import com.closure13k.clase5dia6.model.Student;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(setterPrefix = "with")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    private String id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    
    public static StudentDTO fromStudent(Student student) {
        return StudentDTO.builder()
                .withName(student.getName())
                .withSurname(student.getSurname())
                .withBirthdate(student.getBirthdate())
                .build();
    }
    
}
