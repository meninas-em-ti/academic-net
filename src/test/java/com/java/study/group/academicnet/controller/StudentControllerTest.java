package com.java.study.group.academicnet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.java.study.group.academicnet.model.Student;
import com.java.study.group.academicnet.repository.StudentRepository;
import lombok.var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    private Student student;
    private Instant registerDate;
    private ObjectMapper objectMapper;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    StudentRepository studentRepository;
    private Student studentToUpdate;

    @BeforeEach
    void setUp() {
        registerDate = Instant.parse("2022-05-04T11:27:19.0Z");

        student =  new Student(123L,
                "Bruna", "1234-567",
                "bruna@gmail.com", registerDate);

        studentToUpdate = new Student(123L,
                "Bruna Souza", "567-567",
                "BrunaSouza@gmail.com", registerDate);

        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        studentRepository.deleteAll();
    }

    private String getUrlService() {
        return "http://localhost:" + port + "/students/";
    }

    @Test
    void listAll() {
    }

    @Test
    void register() throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpRequest = new HttpEntity<>(objectMapper.writeValueAsString(student), httpHeaders);
        var responseCode = restTemplate.postForEntity(getUrlService(), httpRequest, Student.class).getStatusCode();

        assertEquals(HttpStatus.OK, responseCode);
    }

    @Test
    void update() {
        var responseCode = restTemplate.exchange(
            getUrlService(), HttpMethod.PUT, new HttpEntity<>(studentToUpdate), String.class)
                .getStatusCode();

        assertEquals(HttpStatus.OK, responseCode);
    }

    @Test
    void delete() {

    }

    @Test
    void listAStudent() {
    }
}