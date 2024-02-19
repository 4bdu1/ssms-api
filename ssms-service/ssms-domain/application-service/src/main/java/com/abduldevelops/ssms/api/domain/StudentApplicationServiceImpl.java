package com.abduldevelops.ssms.api.domain;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.port.input.service.StudentApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Validated
@Service
public class StudentApplicationServiceImpl implements StudentApplicationService {

    private final CreateStudentCommandHandler createStudentCommandHandler;

    @Override
    public CreateStudentResponse createStudent(CreateStudentCommand createStudentCommand) {
        return createStudentCommandHandler.createStudent(createStudentCommand);
    }
}
