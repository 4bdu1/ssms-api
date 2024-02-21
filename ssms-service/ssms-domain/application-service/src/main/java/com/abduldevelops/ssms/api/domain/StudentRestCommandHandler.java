package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentQuery;
import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.exception.StudentNotFoundException;
import com.abduldevelops.ssms.api.domain.mapper.StudentDataMapper;
import com.abduldevelops.ssms.api.domain.port.output.repository.StudentRepository;
import com.abduldevelops.ssms.api.domain.valueobject.StudentSlugID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class StudentRestCommandHandler {

    private final StudentDataMapper studentDataMapper;
    private final CreateStudentHelper createStudentHelper;
    private final StudentRepository studentRepository;

    public CreateStudentResponse createStudent(CreateStudentCommand createStudentCommand){
        Student student = createStudentHelper.saveStudent(createStudentCommand);
        log.info("Student with id: {} has been created successfully",student.getId().getValue());
        return studentDataMapper.studentToCreateStudentResponse(student);
    }

    @Transactional
    public void deleteStudent(GetStudentQuery getStudentQuery) {
            if( !studentRepository.deleteBySlugID(new StudentSlugID(getStudentQuery.getStudentSlugID())) ){
                throw new StudentNotFoundException("Student with id: "
                        + getStudentQuery.getStudentSlugID().toString()
                        + " could not be found");
            }

    }
}
