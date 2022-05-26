package com.java.study.group.academicnet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.java.study.group.academicnet.model.Student;
import com.java.study.group.academicnet.repository.StudentRepository;
import lombok.var;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcademicNetApplicationTests {

	final Instant registerDate = Instant.parse("2022-05-04T11:27:19.0Z");

	private final Student student =  new Student(123L,
			"Bruna", "1234-567",
			"bruna@gmail.com", registerDate);

	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	StudentRepository studentRepository;

	@BeforeAll
	static void environmentSetup() {

	}

	private String getUrlService() {
		return "http://localhost:" + port + "/students/";
	}

	@Test
	void insertStudent() throws Exception {
		studentRepository.deleteAll();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpRequest = new HttpEntity<>(objectMapper.writeValueAsString(student), httpHeaders);
		var responseCode = restTemplate.postForEntity(getUrlService(), httpRequest, Student.class).getStatusCode();

		assertEquals(HttpStatus.OK, responseCode);
	}

}
