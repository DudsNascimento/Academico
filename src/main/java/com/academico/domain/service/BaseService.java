package com.academico.domain.service;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import java.io.Serializable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;
import com.google.common.collect.ImmutableList;
import com.academico.domain.entity.BaseEntity;
import com.academico.domain.repository.BaseRepositoryInterface;
import com.academico.domain.validator.BaseValidatorInterface;

public abstract class BaseService<T extends BaseEntity> implements BaseServiceInterface<T> {

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public T obterPorId(UUID id) {

        Optional<T> retorno = this.getBaseRepository().findById(id);
        return retorno.isPresent() ? retorno.get() : null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<T> obterTodos() {

        return ImmutableList.copyOf(this.getBaseRepository().findAll());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void salvar(T entity) {

        if(entity.isNew()) {
            entity.create();
            this.getBaseValidator().validateCreate(entity);
        } else {
            this.getBaseValidator().validateUpdate(entity);
        }
        this.getBaseRepository().save(entity);
    }

    protected abstract BaseRepositoryInterface<T> getBaseRepository();
    protected abstract BaseValidatorInterface<T> getBaseValidator();
}