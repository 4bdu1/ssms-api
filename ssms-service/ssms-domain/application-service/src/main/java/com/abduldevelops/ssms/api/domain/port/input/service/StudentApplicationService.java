package com.abduldevelops.ssms.api.domain.port.input.service;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import jakarta.validation.Valid;

public interface StudentApplicationService {

    CreateStudentResponse createStudent(@Valid CreateStudentCommand createStudentCommand);
}
