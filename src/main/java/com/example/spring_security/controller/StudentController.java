package com.example.spring_security.controller;

import com.example.spring_security.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Gabriel"),
            new Student(2, "Maria"),
            new Student(3, "João")
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
      students.add(student);
      return student;
    }

}
