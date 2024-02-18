package com.abduldevelops.ssms.api.domain.service;

import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.valueobject.EmailAddress;
import com.abduldevelops.ssms.api.domain.valueobject.StudentName;

public interface DomainService {

    Student validateAndCreateStudent(Student student);
    Student updateStudentName(Student student, StudentName newName);
    Student updateStudentEmailAddress(Student student, EmailAddress newEmailAddress);
}
