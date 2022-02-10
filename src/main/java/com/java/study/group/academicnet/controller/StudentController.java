package com.java.study.group.academicnet.controller;

import com.java.study.group.academicnet.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public Student getInfo(){

        Student student = new Student(1L, "Luis Viton", "111122", "viton@luis.com", Instant.now());

        return student;
    }
}
