package com.abduldevelops.ssms.api.domain.entity;

import com.abduldevelops.ssms.api.domain.valueobject.EmailAddress;
import com.abduldevelops.ssms.api.domain.valueobject.StudentID;
import com.abduldevelops.ssms.api.domain.valueobject.StudentName;
import com.abduldevelops.ssms.api.domain.valueobject.StudentSlugID;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Student extends AggregateRoot<StudentID> {

    private final StudentName studentName;
    private final EmailAddress emailAddress;

    private StudentSlugID studentSlugID;

    private  ZonedDateTime createdAt;
    private  ZonedDateTime modifiedAt;

    private Student(Builder builder) {
        super.setId(builder.studentID);
        studentSlugID = builder.studentSlugID;
        studentName = builder.studentName;
        emailAddress = builder.emailAddress;
        createdAt = builder.createdAt;
        modifiedAt = builder.modifiedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public StudentSlugID getStudentSlugID() {
        return studentSlugID;
    }


    public StudentName getStudentName() {
        return studentName;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void initAddStudent(){
        setId(new StudentID(UUID.randomUUID()));
        studentSlugID = new StudentSlugID(UUID.randomUUID());
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        modifiedAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    public Student updateStudentName(Student student, String firstName, String lastName){
        return Student.builder()
                .id(student.getId())
                .studentName(new StudentName(firstName, lastName))
                .emailAddress(student.getEmailAddress())
                .build();

    }

    public Student updateEmailAddress(Student student, String newEmail){
        return Student.builder()
                .id(student.getId())
                .studentName(student.getStudentName())
                .emailAddress(new EmailAddress(newEmail))
                .build();
    }


    public static final class Builder {
        private StudentID studentID;
        private StudentSlugID studentSlugID;
        private StudentName studentName;
        private EmailAddress emailAddress;
        private ZonedDateTime createdAt;
        private ZonedDateTime modifiedAt;

        private Builder() {
        }


        public Builder id(StudentID val) {
            studentID = val;
            return this;
        }

        public Builder studentSlugID(StudentSlugID val) {
            studentSlugID = val;
            return this;
        }

        public Builder studentName(StudentName val) {
            studentName = val;
            return this;
        }

        public Builder emailAddress(EmailAddress val) {
            emailAddress = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder modifiedAt(ZonedDateTime val) {
            modifiedAt = val;
            return this;
        }


        public Student build() {
            return new Student(this);
        }
    }
}
