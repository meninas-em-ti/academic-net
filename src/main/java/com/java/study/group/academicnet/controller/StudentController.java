package com.java.study.group.academicnet.controller;

import com.java.study.group.academicnet.model.Student;
import com.java.study.group.academicnet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> listAll(){
        return studentRepository.findAll();
    }

    @PostMapping
    public void register (@RequestBody Student student){

        studentRepository.save(student);
    }

    @PutMapping
    public void update(@RequestBody Student student){
        studentRepository.save(student);
    }
}
