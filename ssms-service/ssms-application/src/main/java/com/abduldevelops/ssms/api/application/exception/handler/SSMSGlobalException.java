package com.abduldevelops.ssms.api.application.exception.handler;

import com.abduldevelops.ssms.api.domain.exception.StudentDomainException;
import com.abduldevelops.ssms.api.domain.exception.StudentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@Slf4j
@RestControllerAdvice
public class SSMSGlobalException extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {StudentDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleException(StudentDomainException studentDomainException) {
        log.error(studentDomainException.getMessage(), studentDomainException);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, studentDomainException.getMessage());
        problemDetail.setType(URI.create("/errors/domain-exception")); //This should point to documentation of the error
        return problemDetail;
    }

    @ResponseBody
    @ExceptionHandler(value = {StudentNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleException(StudentNotFoundException studentNotFoundException) {
        log.error(studentNotFoundException.getMessage(), studentNotFoundException);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, studentNotFoundException.getMessage());
        problemDetail.setType(URI.create("/errors/not-found")); //This should point to documentation of the error
        return problemDetail;
    }
}
