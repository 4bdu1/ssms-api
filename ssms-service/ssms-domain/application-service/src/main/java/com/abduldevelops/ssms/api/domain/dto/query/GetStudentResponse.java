package com.abduldevelops.ssms.api.domain.dto.query;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetStudentResponse {

    @NotNull
    private final UUID studentSlugID;

    @NotNull(message="firstName can't be null")
    private final String firstName;

    @NotNull(message="lastName can't be null")
    private final String lastName;

    @NotNull(message = "emailAddress can't be null")
    @Email(message="emailAddress must be a well-formed email address")
    private final String emailAddress;

    private ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;
}
