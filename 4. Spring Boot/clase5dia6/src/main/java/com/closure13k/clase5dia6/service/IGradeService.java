package com.closure13k.clase5dia6.service;

import com.closure13k.clase5dia6.model.Grade;
import com.closure13k.clase5dia6.model.Student;

import java.util.List;
import java.util.Optional;

public interface IGradeService {
    List<Student> getAllStudents();
    Optional<Grade> getGradeByStudent(String studentId);
    List<Grade> getAllGradesSortedByAverage();
    
    
}
