package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentQuery;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentResponse;
import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.exception.StudentNotFoundException;
import com.abduldevelops.ssms.api.domain.mapper.StudentDataMapper;
import com.abduldevelops.ssms.api.domain.port.input.service.StudentApplicationService;
import com.abduldevelops.ssms.api.domain.port.output.repository.StudentRepository;
import com.abduldevelops.ssms.api.domain.service.DomainService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@SpringBootTest(classes = StudentTestConfiguration.class )
class StudentApplicationServiceImplTest {

    @Autowired
    private StudentApplicationService studentApplicationService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDataMapper studentDataMapper;

    @Autowired
    private DomainService domainService;

    private CreateStudentCommand createStudentCommandWithValidInput;
    private CreateStudentCommand createStudentCommandWithInvalidInput;

    private final UUID STUDENT_SLUG_ID = UUID.fromString("ce88e34a-b967-4a8d-94a0-6defc445d8de");

    @BeforeEach
    public void init(){
        createStudentCommandWithValidInput = CreateStudentCommand.builder()
                .firstName("Jane")
                .lastName("Doe")
                .emailAddress("janedoe@email.com")
                .build();

        createStudentCommandWithInvalidInput = CreateStudentCommand.builder()
                .lastName("Doe")
                .emailAddress("janedoe@email.com")
                .build();

    }

    @Test
    public void testCreateStudentWithValidInput(){
        Student validStudent = studentDataMapper.createStudentCommandToStudent(createStudentCommandWithValidInput);
        domainService.validateAndCreateStudent(validStudent);
        when(studentRepository.save(any(Student.class))).thenReturn(validStudent);
        when(studentRepository.findByEmailAddress(validStudent.getEmailAddress())).thenReturn(Optional.empty());
        CreateStudentResponse createStudentResponse = studentApplicationService.createStudent(createStudentCommandWithValidInput);
        assertNotNull(createStudentResponse.getStudentSlugID());
    }

    @Test
    public void testCreateStudentWithInvalidInput(){
        ConstraintViolationException constraintViolationException = assertThrows(ConstraintViolationException.class,() ->
                studentApplicationService.createStudent(createStudentCommandWithInvalidInput));

        assertEquals(constraintViolationException.getMessage(), "createStudent.createStudentCommand.firstName: firstName can't be null");

    }

    @Test
    public void testGetStudentWithSlugId(){
        Student validStudent = studentDataMapper.createStudentCommandToStudent(createStudentCommandWithValidInput);
        domainService.validateAndCreateStudent(validStudent);
        when(studentRepository.findBySlugID(validStudent.getStudentSlugID())).thenReturn(Optional.of(validStudent));

        GetStudentResponse getStudentResponse = studentApplicationService.getStudent(new GetStudentQuery(validStudent.getStudentSlugID().getValue()));

        assertEquals(getStudentResponse.getStudentSlugID(),validStudent.getStudentSlugID().getValue());
        assertEquals(getStudentResponse.getFirstName(),validStudent.getStudentName().getFirstName());
    }


    @Test
    public void testGetStudentWithSlugIdNotFound(){
        StudentNotFoundException studentNotFoundException = assertThrows(StudentNotFoundException.class, ()->{
            studentApplicationService.getStudent(new GetStudentQuery(STUDENT_SLUG_ID));
        });

        assertEquals(studentNotFoundException.getMessage(), "Student with slug id "+STUDENT_SLUG_ID+" was not found");

    }




}