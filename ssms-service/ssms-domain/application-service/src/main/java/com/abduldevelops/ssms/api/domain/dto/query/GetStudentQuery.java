package com.abduldevelops.ssms.api.domain.dto.query;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetStudentQuery {
    @NotNull
    private final UUID studentSlugID;
}
