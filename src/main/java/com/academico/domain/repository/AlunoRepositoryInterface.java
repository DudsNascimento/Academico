package com.academico.domain.repository;

import java.util.UUID;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.academico.domain.entity.Aluno;
import com.academico.domain.repository.BaseRepositoryInterface;

@Repository
public interface AlunoRepositoryInterface extends BaseRepositoryInterface<Aluno> {

    Optional<Aluno> findByCpf(String cpf);
}