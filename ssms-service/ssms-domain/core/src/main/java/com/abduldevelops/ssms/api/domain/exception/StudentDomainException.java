package com.abduldevelops.ssms.api.domain.exception;

public class StudentDomainException extends DomainException{
    public StudentDomainException(String message) {
        super(message);
    }

    public StudentDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
