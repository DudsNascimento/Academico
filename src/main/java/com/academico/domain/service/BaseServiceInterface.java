package com.academico.domain.service;

import java.util.UUID;
import java.util.List;
import com.academico.domain.entity.BaseEntity;

public interface BaseServiceInterface<T extends BaseEntity> {

    T obterPorId(UUID id);
    List<T> obterTodos();
    void salvar(T entity);
}