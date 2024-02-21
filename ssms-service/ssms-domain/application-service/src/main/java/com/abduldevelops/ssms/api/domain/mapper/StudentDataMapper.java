package com.abduldevelops.ssms.api.domain.mapper;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.dto.command.UpdateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentResponse;
import com.abduldevelops.ssms.api.domain.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentDataMapper {

    @Mapping(target = "emailAddress.emailAddress", source = "createStudentCommand.emailAddress")
    @Mapping(target = "studentName.firstName", source = "createStudentCommand.firstName")
    @Mapping(target = "studentName.lastName", source = "createStudentCommand.lastName")
    Student createStudentCommandToStudent(CreateStudentCommand createStudentCommand);

    @Mapping(target = "emailAddress.emailAddress", source = "updateStudentCommand.emailAddress")
    @Mapping(target = "studentName.firstName", source = "updateStudentCommand.firstName")
    @Mapping(target = "studentName.lastName", source = "updateStudentCommand.lastName")
    Student updateStudentCommandToStudent(UpdateStudentCommand updateStudentCommand);

    @Mapping(target = "studentSlugID", source ="student.studentSlugID.value")
    CreateStudentResponse studentToCreateStudentResponse(Student student);


    @Mapping(source="emailAddress.emailAddress",target="emailAddress")
    @Mapping(source="studentName.firstName",target="firstName")
    @Mapping(source="studentName.lastName",target="lastName")
    @Mapping(source="studentSlugID.value",target="studentSlugID")
    GetStudentResponse studentToGetStudentResponse(Student student);
}
