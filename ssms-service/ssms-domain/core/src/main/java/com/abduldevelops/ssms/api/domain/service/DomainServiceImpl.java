package com.abduldevelops.ssms.api.domain.service;

import com.abduldevelops.ssms.api.domain.entity.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainServiceImpl implements DomainService {
    @Override
    public Student validateAndCreateStudent(Student student) {
        student.initAddStudent();
        log.info("Student with id: {} has been initialized", student.getId().getValue());
        return student;
    }

}
