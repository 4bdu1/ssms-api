package com.abduldevelops.ssms.api.domain.port.output.repository;

import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.valueobject.StudentSlugID;

import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findBySlugID(StudentSlugID studentSlugID);
}
