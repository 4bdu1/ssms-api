package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.dto.query.GetStudentQuery;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentResponse;
import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.exception.StudentNotFoundException;
import com.abduldevelops.ssms.api.domain.mapper.StudentDataMapper;
import com.abduldevelops.ssms.api.domain.port.output.repository.StudentRepository;
import com.abduldevelops.ssms.api.domain.valueobject.StudentSlugID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetStudentQueryHandler {

    private final StudentDataMapper studentDataMapper;

    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    GetStudentResponse getStudent(GetStudentQuery getStudentQuery){
        Optional<Student> studentResult =  studentRepository.findBySlugID(new StudentSlugID(getStudentQuery.getStudentSlugID()));

        if(studentResult.isEmpty()){
            log.info("Student with slug id {} was not found", getStudentQuery.getStudentSlugID());
            throw new StudentNotFoundException("Student with slug id "+ getStudentQuery.getStudentSlugID() +" was not found");
        }

        return studentDataMapper.studentToGetStudentResponse(studentResult.get());
    }
}
