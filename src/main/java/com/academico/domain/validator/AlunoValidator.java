package com.academico.domain.validator;

import org.springframework.beans.factory.annotation.Autowired;
import com.academico.domain.entity.BaseEntity;
import com.academico.domain.entity.Aluno;
import com.academico.domain.repository.AlunoRepositoryInterface;
import com.academico.infrastructure.exception.BusinessException;

public class AlunoValidator implements BaseValidatorInterface<Aluno> {

    @Autowired
    public AlunoRepositoryInterface alunoRepository;

    public void validateCreate(Aluno entity) {
        if(this.alunoRepository.findByCpf(entity.getCpf()).isPresent()) {
            throw new BusinessException("Erro ao cadastrar aluno: CPF já existe");
        }
    }

    public void validateUpdate(Aluno entity) {
    }
}