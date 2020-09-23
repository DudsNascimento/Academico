package com.academico.application.facade;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;
import com.academico.application.viewmodel.AlunoViewModel;
import com.academico.domain.service.AlunoServiceInterface;
import com.academico.domain.entity.Aluno;
import com.academico.infrastructure.exception.InternalErrorException;

public class AlunoFacade implements AlunoFacadeInterface {

    @Inject
    AlunoServiceInterface alunoService;

    @Inject
    private ModelMapper modelMapper;

    public AlunoFacade() {

        this.alunoService = alunoService;
    }

    public AlunoViewModel obterPorId(UUID id) {

        return modelMapper.map(this.alunoService.obterPorId(id), AlunoViewModel.class);
    }

    public List<AlunoViewModel> obterTodos() {

        return this.alunoService
            .obterTodos()
            .stream()
            .map(aluno -> modelMapper.map(aluno, AlunoViewModel.class))
            .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void salvar(AlunoViewModel aluno) {
        
        this.alunoService.salvar(modelMapper.map(aluno, Aluno.class));
    }
}