package com.academico.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.academico.domain.entity.Aluno;
import com.academico.domain.repository.BaseRepositoryInterface;
import com.academico.domain.repository.AlunoRepositoryInterface;
import com.academico.domain.validator.BaseValidatorInterface;

public class AlunoService extends BaseService<Aluno> implements AlunoServiceInterface {

    @Autowired
    public AlunoRepositoryInterface alunoRepository;

    @Autowired
    public BaseValidatorInterface<Aluno> alunoValidator;

    @Override
    protected BaseRepositoryInterface<Aluno> getBaseRepository() {
        return this.alunoRepository;
    }

    @Override
    protected BaseValidatorInterface<Aluno> getBaseValidator() {
        return this.alunoValidator;
    }
}