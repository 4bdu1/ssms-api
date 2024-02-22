package com.abduldevelops.ssms.api.application.rest;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.dto.command.UpdateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentQuery;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentResponse;
import com.abduldevelops.ssms.api.domain.port.input.service.StudentApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name="Student", description= "the simple student management API")
public class StudentApplicationController {
    private final StudentApplicationService studentApplicationService;
    public static final String STUDENT_PATH = "/api/v1/students";
    public static final String STUDENT_PATH_ID = STUDENT_PATH + "/{studentSlugID}";

    @Operation(summary = "Gets all students paged", description = "Get all students paged", tags = {"Student"})
    @GetMapping(STUDENT_PATH)
    public Page<GetStudentResponse> getAllStudents(@RequestParam(required = false) Integer pageNumber,
                                  @RequestParam(required = false) Integer pageSize){
        log.info("Getting all students paginated");
        return studentApplicationService.getAllStudents(pageNumber, pageSize);
    }

    @Operation(summary = "Adds a new student", description = "Add a new student with unique email address", tags = {"Student"})
    @PostMapping(STUDENT_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateStudentResponse> createStudent(@RequestBody CreateStudentCommand createStudentCommand){
        log.info("Creating student with email {}", createStudentCommand.getEmailAddress());
        CreateStudentResponse createStudentResponse = studentApplicationService.createStudent(createStudentCommand);
        log.info("Student created with slug ID {}", createStudentResponse.getStudentSlugID());
        HttpHeaders headers =  new HttpHeaders();
        headers.add("Location", "/api/v1/students/" + createStudentResponse.getStudentSlugID().toString());
        return new ResponseEntity<>(createStudentResponse, headers, HttpStatus.CREATED);
    }


    @Operation(summary = "Finds a student by student slug ID", description = "Return a single student", tags = {"Student"})
    @GetMapping(STUDENT_PATH_ID)
    public ResponseEntity<GetStudentResponse> getStudent(@PathVariable UUID studentSlugID) {
        log.info("Getting student with slug ID {}", studentSlugID);
        GetStudentResponse getStudentResponse = studentApplicationService.getStudent(GetStudentQuery.builder().studentSlugID(studentSlugID).build());
        return ResponseEntity.ok(getStudentResponse);
    }

    @Operation(summary = "Deletes a student by student slug ID", description = "", tags = {"Student"})
    @DeleteMapping(STUDENT_PATH_ID)
    public ResponseEntity deleteStudent(@PathVariable UUID studentSlugID) {
        log.info("Deleting student with slug ID {}", studentSlugID);
        studentApplicationService.deleteStudent(GetStudentQuery.builder().studentSlugID(studentSlugID).build());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Updates an existing student", description = "Updates an existing student by student slug ID", tags = {"Student"})
    @PutMapping(STUDENT_PATH_ID)
    public ResponseEntity updateStudent(@PathVariable UUID studentSlugID, @RequestBody UpdateStudentCommand updateStudentCommand) {
        log.info("Updating student with slug ID {}", studentSlugID);
        studentApplicationService.updateStudent(GetStudentQuery.builder().studentSlugID(studentSlugID).build(),updateStudentCommand);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
