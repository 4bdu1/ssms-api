package com.abduldevelops.ssms.api.dataaccess.student.repository;

import com.abduldevelops.ssms.api.dataaccess.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, UUID> {
    Optional<StudentEntity> findByStudentSlugID(UUID studentSlugID);
    Optional<StudentEntity> findByEmailAddress(String emailAddress);
    void deleteByStudentSlugID(UUID studentSlugID);



}
