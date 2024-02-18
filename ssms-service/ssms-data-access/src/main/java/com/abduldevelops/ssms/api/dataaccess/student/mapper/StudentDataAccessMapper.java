package com.abduldevelops.ssms.api.dataaccess.student.mapper;


import com.abduldevelops.ssms.api.dataaccess.student.entity.StudentEntity;
import com.abduldevelops.ssms.api.domain.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentDataAccessMapper {

    @Mapping(target="firstName",source = "studentName.firstName")
    @Mapping(target="lastName",source = "studentName.lastName")
    @Mapping(target="studentSlugID",source = "studentSlugID.value")
    @Mapping(target="emailAddress",source = "emailAddress.emailAddress")
    @Mapping(target="studentID",source = "id.value")
    StudentEntity studentToStudentEntity(Student student);

//    Student studentEntityToStudent(StudentEntity studentEntity);
}
