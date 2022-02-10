package com.java.study.group.academicnet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;


@Data
@AllArgsConstructor
@Entity
public class Student {

    @Id
    private Long registrationID;
    private String name;
    private String phoneNumber;
    private String email;
    private Instant registrationDate;
}
