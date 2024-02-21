package com.abduldevelops.ssms.api.domain.dto.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UpdateStudentCommand {

    @NotBlank
    @NotNull(message="firstName can't be null")
    private final String firstName;

    @NotBlank
    @NotNull(message="lastName can't be null")
    private final String lastName;

    @NotBlank
    @NotNull(message = "emailAddress can't be null")
    @Email(message="emailAddress must be a well-formed email address")
    private final String emailAddress;
}
