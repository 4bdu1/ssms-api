package com.abduldevelops.ssms.api.domain.port.input.service;

import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentCommand;
import com.abduldevelops.ssms.api.domain.dto.command.CreateStudentResponse;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentQuery;
import com.abduldevelops.ssms.api.domain.dto.query.GetStudentResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface StudentApplicationService {

    CreateStudentResponse createStudent(@Valid CreateStudentCommand createStudentCommand);
    GetStudentResponse getStudent(@Valid GetStudentQuery getStudentQuery);
    Page<GetStudentResponse> getAllStudents(Integer pageNumber, Integer pageSize);


}
