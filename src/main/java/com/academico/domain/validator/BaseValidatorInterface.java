package com.academico.domain.validator;

import com.academico.domain.entity.BaseEntity;

public interface BaseValidatorInterface<T extends BaseEntity> {

    void validateCreate(T entity);
    void validateUpdate(T entity);
}