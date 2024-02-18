package com.abduldevelops.ssms.api.domain.dto.command;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateStudentResponse {
    @NotNull
    private final UUID studentSlugID;
}
