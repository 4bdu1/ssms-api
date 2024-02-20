package com.abduldevelops.ssms.api.domain.port.output.repository;

import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.valueobject.StudentSlugID;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    Page<Student> findAll(Integer pageNumber, Integer pageSize);

    Optional<Student> updateBySlugID(StudentSlugID studentSlugID, Student student);

    Optional<Student> patchBySlugID(StudentSlugID studentSlugID, Student student);

    Boolean deleteBySlugID(StudentSlugID studentSlugID);

    Optional<Student> findBySlugID(StudentSlugID studentSlugID);
}
