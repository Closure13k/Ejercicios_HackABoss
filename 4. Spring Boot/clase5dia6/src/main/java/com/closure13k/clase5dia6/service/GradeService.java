package com.closure13k.clase5dia6.service;

import com.closure13k.clase5dia6.dto.GradeDTO;
import com.closure13k.clase5dia6.model.Grade;
import com.closure13k.clase5dia6.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeService implements IGradeService {
    
    private static final List<Grade> GRADE_LIST = preLoadGrades();
    
    @Override
    public List<Student> getAllStudents() {
        return GRADE_LIST.stream()
                .map(Grade::getStudent)
                .toList();
    }
    
    @Override
    public Optional<Grade> getGradeByStudent(String studentId) {
        return GRADE_LIST.stream()
                .filter(grade -> grade.getStudent().getId().equals(studentId))
                .findFirst();
    }
    
    @Override
    public List<Grade> getAllGradesSortedByAverage() {
        return GRADE_LIST.stream()
                .sorted((grade1, grade2) -> Double.compare(grade2.getAverage(), grade1.getAverage()))
                .toList();
    }
    
    private static List<Grade> preLoadGrades() {
        return new ArrayList<>(
                List.of(
                        new Grade("1", 10d, 9d, 8d, new Student("1", "Juan", "Perez", LocalDate.of(1990, 1, 1))),
                        new Grade("2", 7d, 6d, 5d, new Student("2", "Maria", "Gomez", LocalDate.of(1991, 2, 2))),
                        new Grade("3", 4d, 3d, 2d, new Student("3", "Pedro", "Gonzalez", LocalDate.of(1992, 3, 3))),
                        new Grade("4", 10d, 10d, 10d, new Student("4", "Jose", "Rodriguez", LocalDate.of(1993, 4, 4))),
                        new Grade("5", 1d, 2d, 3d, new Student("5", "Ana", "Lopez", LocalDate.of(1994, 5, 5)))
                )
        );
    }
    
    
}
