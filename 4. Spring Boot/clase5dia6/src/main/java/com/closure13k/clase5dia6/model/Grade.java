package com.closure13k.clase5dia6.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private String id;
    private Double grade1;
    private Double grade2;
    private Double grade3;
    private Double average;
    private Student student;
    
    public Grade(String id, Double grade1, Double grade2, Double grade3, Student student) {
        this.id = id;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.average = (grade1 + grade2 + grade3) / 3;
        this.student = student;
    }
    
}