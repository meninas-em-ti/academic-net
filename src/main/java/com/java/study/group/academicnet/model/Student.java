package com.java.study.group.academicnet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    private Long registrationID;
    private String name;
    private String phoneNumber;
    private String email;
    private Instant registrationDate;
}
