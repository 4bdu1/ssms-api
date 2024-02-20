package com.abduldevelops.ssms.api.application.rest;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentQuery;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentResponse;
import com.abduldevelops.ssms.api.domain.port.input.service.StudentApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="api/v1/students")
public class StudentApplicationController {
    private final StudentApplicationService studentApplicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateStudentResponse> createStudent(@RequestBody CreateStudentCommand createStudentCommand){
        log.info("Creating student with email {}", createStudentCommand.getEmailAddress());
        CreateStudentResponse createStudentResponse = studentApplicationService.createStudent(createStudentCommand);
        log.info("Student created with slug ID {}", createStudentResponse.getStudentSlugID());
        HttpHeaders headers =  new HttpHeaders();
        headers.add("Location", "/api/v1/students/" + createStudentResponse.getStudentSlugID().toString());
        return new ResponseEntity<>(createStudentResponse, headers, HttpStatus.CREATED);
    }


    @GetMapping("/{studentSlugID}")
    public ResponseEntity<GetStudentResponse> getStudent(@PathVariable UUID studentSlugID){
        log.info("Getting student with slug ID {}", studentSlugID);
        GetStudentResponse getStudentResponse = studentApplicationService.getStudent(GetStudentQuery.builder().studentSlugID(studentSlugID).build());
        return ResponseEntity.ok(getStudentResponse);
    }

}
