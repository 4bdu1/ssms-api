package com.abduldevelops.ssms.api.domain.core.valueobject;

import com.abduldevelops.ssms.api.domain.valueobject.BaseID;

import java.util.UUID;

public class StudentID extends BaseID<UUID> {


    public StudentID(UUID value) {
        super(value);
    }
}
