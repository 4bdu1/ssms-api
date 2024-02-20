package com.abduldevelops.ssms.api.domain.exception;

public class StudentNotFoundException extends DomainException{
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
