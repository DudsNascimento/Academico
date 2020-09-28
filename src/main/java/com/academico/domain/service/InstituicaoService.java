package com.academico.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.academico.domain.entity.Instituicao;
import com.academico.domain.repository.BaseRepositoryInterface;
import com.academico.domain.repository.InstituicaoRepositoryInterface;
import com.academico.domain.validator.BaseValidatorInterface;

public class InstituicaoService extends BaseService<Instituicao> implements InstituicaoServiceInterface {

    @Autowired
    public InstituicaoRepositoryInterface instituicaoRepository;

    @Autowired
    public BaseValidatorInterface<Instituicao> instituicaoValidator;

    @Override
    protected BaseRepositoryInterface<Instituicao> getBaseRepository() {
        return this.instituicaoRepository;
    }

    @Override
    protected BaseValidatorInterface<Instituicao> getBaseValidator() {
        return this.instituicaoValidator;
    }
}