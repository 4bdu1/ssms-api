package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.mapper.StudentDataMapper;
import com.abduldevelops.ssms.api.domain.service.DomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateStudentHelper {
//    private final StudentRepository studentRepository;
    private final StudentDataMapper studentDataMapper;
    private final DomainService domainService;

    @Transactional
    public Student saveStudent(CreateStudentCommand createStudentCommand){
        Student student = studentDataMapper.createStudentCommandToStudent(createStudentCommand);
        domainService.validateAndCreateStudent(student);
//        Student savedStudent = studentRepository.save(student);
//
//        if(savedStudent == null){
//            log.error("Could not save student.");
//            //throw exception
//        }
//
//        log.info("Student with id: {} has been saved", savedStudent.getId().getValue());
        return Student.builder().build();
    }

}
