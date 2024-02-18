package com.abduldevelops.ssms.api.domain.service;

import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.valueobject.EmailAddress;
import com.abduldevelops.ssms.api.domain.valueobject.StudentName;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainServiceImpl implements DomainService {
    @Override
    public Student validateAndCreateStudent(Student student) {
        student.initAddStudent();
        log.info("Student with id: {} has been initialized", student.getId().getValue());
        return student;
    }

    @Override
    public Student updateStudentName(Student student, StudentName newName) {
        return null;
    }

    @Override
    public Student updateStudentEmailAddress(Student student, EmailAddress newEmailAddress) {
        return null;
    }
}
