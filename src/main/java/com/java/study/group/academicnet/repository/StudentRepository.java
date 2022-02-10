package com.java.study.group.academicnet.repository;

import com.java.study.group.academicnet.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
