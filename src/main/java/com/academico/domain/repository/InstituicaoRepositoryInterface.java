package com.academico.domain.repository;

import java.util.UUID;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.academico.domain.entity.Instituicao;
import com.academico.domain.repository.BaseRepositoryInterface;

@Repository
public interface InstituicaoRepositoryInterface extends BaseRepositoryInterface<Instituicao> {

}