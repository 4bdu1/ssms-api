package com.abduldevelops.ssms.api.application.rest;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.port.input.service.StudentApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="api/v1/students")
public class StudentApplicationController {
    private final StudentApplicationService studentApplicationService;

    @PostMapping
    public ResponseEntity<CreateStudentResponse> createStudent(@RequestBody CreateStudentCommand createStudentCommand){
        log.info("Creating student with email {}", createStudentCommand.getEmailAddress());
        CreateStudentResponse createStudentResponse = studentApplicationService.createStudent(createStudentCommand);
        log.info("Student created with slug ID {}", createStudentResponse.getStudentSlugID());
        return ResponseEntity.ok(createStudentResponse);
    }

}
