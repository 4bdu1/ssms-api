package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentQuery;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentResponse;
import com.abduldevelops.ssms.api.domain.port.input.service.StudentApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Validated
@Service
public class StudentApplicationServiceImpl implements StudentApplicationService {

    private final StudentRestCommandHandler studentRestCommandHandler;
    private final GetStudentQueryHandler getStudentQueryHandler;

    @Override
    public CreateStudentResponse createStudent(CreateStudentCommand createStudentCommand) {
        return studentRestCommandHandler.createStudent(createStudentCommand);
    }

    @Override
    public GetStudentResponse getStudent(GetStudentQuery getStudentQuery) {
        return getStudentQueryHandler.getStudent(getStudentQuery);
    }

    @Override
    public void deleteStudent(GetStudentQuery getStudentQuery) {
        studentRestCommandHandler.deleteStudent(getStudentQuery);
    }

    @Override
    public Page<GetStudentResponse> getAllStudents(Integer pageNumber, Integer pageSize) {
        return getStudentQueryHandler.getAllStudents(pageNumber,pageSize);
    }
}
