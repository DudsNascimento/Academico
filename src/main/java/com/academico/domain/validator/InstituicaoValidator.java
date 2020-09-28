package com.academico.domain.validator;

import org.springframework.beans.factory.annotation.Autowired;
import com.academico.domain.entity.BaseEntity;
import com.academico.domain.entity.Instituicao;
import com.academico.domain.repository.InstituicaoRepositoryInterface;
import com.academico.infrastructure.exception.BusinessException;

public class InstituicaoValidator implements BaseValidatorInterface<Instituicao> {

    @Autowired
    public InstituicaoRepositoryInterface instituicaoRepository;

    public void validateCreate(Instituicao entity) {
    }

    public void validateUpdate(Instituicao entity) {
    }
}