package com.abduldevelops.ssms.api.dataaccess.student.adapter;

import com.abduldevelops.ssms.api.dataaccess.student.mapper.StudentDataAccessMapper;
import com.abduldevelops.ssms.api.dataaccess.student.repository.StudentJpaRepository;
import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.port.output.repository.StudentRepository;
import com.abduldevelops.ssms.api.domain.valueobject.StudentSlugID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StudentRepositoryImpl implements StudentRepository {
    private final StudentJpaRepository studentJpaRepository;
    private final StudentDataAccessMapper studentDataAccessMapper;

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Optional<Student> findBySlugID(StudentSlugID studentSlugID) {
        return Optional.empty();
    }
}
