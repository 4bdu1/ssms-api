package com.abduldevelops.ssms.api.domain.valueobject;

import java.util.Objects;

public abstract class BaseID<T> {

    private final T value;

    public BaseID(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseID<?> baseID = (BaseID<?>) o;
        return Objects.equals(value, baseID.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
