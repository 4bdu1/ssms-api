package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.exception.StudentDomainException;
import com.abduldevelops.ssms.api.domain.mapper.StudentDataMapper;
import com.abduldevelops.ssms.api.domain.port.output.repository.StudentRepository;
import com.abduldevelops.ssms.api.domain.service.DomainService;
import com.abduldevelops.ssms.api.domain.valueobject.EmailAddress;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateStudentHelper {
    private final StudentRepository studentRepository;
    private final StudentDataMapper studentDataMapper;
    private final DomainService domainService;

    @Transactional
    public Student saveStudent(CreateStudentCommand createStudentCommand){
        Student student = studentDataMapper.createStudentCommandToStudent(createStudentCommand);
        checkEmail(student.getEmailAddress());
        domainService.validateAndCreateStudent(student);
        Student savedStudent = studentRepository.save(student);

        if(savedStudent == null){
            log.error("Could not save student.");
            throw new StudentDomainException("Could not save student");
        }

        log.info("Student with id: {} has been saved", savedStudent.getId().getValue());
        return savedStudent;
    }

    public void checkEmail(EmailAddress emailAddress){
        Optional<Student> existingStudent = studentRepository.findByEmailAddress(emailAddress);

        if(!existingStudent.isEmpty()){
            log.error("Student with email: {} already exists.", emailAddress.getEmailAddress());
            throw new StudentDomainException("Student with email: " +emailAddress.getEmailAddress()+ " already exists.");
        }
    }

}
