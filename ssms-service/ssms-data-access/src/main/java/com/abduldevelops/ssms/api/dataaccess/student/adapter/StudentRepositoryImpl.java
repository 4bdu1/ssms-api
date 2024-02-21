package com.abduldevelops.ssms.api.dataaccess.student.adapter;

import com.abduldevelops.ssms.api.dataaccess.student.entity.StudentEntity;
import com.abduldevelops.ssms.api.dataaccess.student.mapper.StudentDataAccessMapper;
import com.abduldevelops.ssms.api.dataaccess.student.repository.StudentJpaRepository;
import com.abduldevelops.ssms.api.domain.entity.Student;
import com.abduldevelops.ssms.api.domain.port.output.repository.StudentRepository;
import com.abduldevelops.ssms.api.domain.valueobject.EmailAddress;
import com.abduldevelops.ssms.api.domain.valueobject.StudentSlugID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StudentRepositoryImpl implements StudentRepository {
    private final StudentJpaRepository studentJpaRepository;
    private final StudentDataAccessMapper studentDataAccessMapper;
    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;

    @Override
    public Student save(Student student) {
        return studentDataAccessMapper
                .studentEntityToStudent(
                        studentJpaRepository.save(studentDataAccessMapper.studentToStudentEntity(student)));
    }


    @Override
    public Page<Student> findAll(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
        Page<StudentEntity> studentEntityPage = studentJpaRepository.findAll(pageRequest);
        return studentEntityPage.map(studentDataAccessMapper::studentEntityToStudent);

    }


    @Override
    public Optional<Student> updateBySlugID(StudentSlugID studentSlugID, Student student) {
        return Optional.empty();
    }

    @Override
    public Optional<Student> patchBySlugID(StudentSlugID studentSlugID, Student student) {
        return Optional.empty();
    }

    @Override
    public Boolean deleteBySlugID(StudentSlugID studentSlugID) {
        return null;
    }

    @Override
    public Optional<Student> findBySlugID(StudentSlugID studentSlugID) {
        return studentJpaRepository.findByStudentSlugID(studentSlugID.getValue())
                .map(studentDataAccessMapper::studentEntityToStudent);
    }

    @Override
    public Optional<Student> findByEmailAddress(EmailAddress emailAddress) {
        return studentJpaRepository.findByEmailAddress(emailAddress.getEmailAddress())
                .map(studentDataAccessMapper::studentEntityToStudent);
    }

    public PageRequest buildPageRequest(Integer pageNumber, Integer pageSize){
        int queryPageNumber;
        int queryPageSize;

        if(pageNumber != null && pageNumber > 0){
            queryPageNumber = pageNumber-1;
        }else{
            queryPageNumber = DEFAULT_PAGE;
        }

        if(pageSize == null){
            queryPageSize = DEFAULT_PAGE_SIZE;
        }else{
            if (pageSize > 1000){
                queryPageSize = 10000;
            }else{
                queryPageSize = pageSize;
            }

        }

        Sort sort = Sort.by(Sort.Order.asc("firstName"));

        return PageRequest.of(queryPageNumber, queryPageSize, sort);
    }
}
