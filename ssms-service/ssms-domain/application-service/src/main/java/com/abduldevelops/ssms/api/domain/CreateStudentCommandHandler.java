package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.mapper.StudentDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateStudentCommandHandler {

    private final StudentDataMapper studentDataMapper;
    private final CreateStudentHelper createStudentHelper;

    public CreateStudentResponse createStudent(CreateStudentCommand createStudentCommand){
        Student student = createStudentHelper.saveStudent(createStudentCommand);
        log.info("Student with id: {} has been created successfully",student.getId().getValue());
        return studentDataMapper.studentToCreateStudentResponse(student);
    }
}
