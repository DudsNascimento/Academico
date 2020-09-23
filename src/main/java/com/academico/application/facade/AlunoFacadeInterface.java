package com.academico.application.facade;

import java.util.UUID;
import java.util.List;
import com.academico.application.viewmodel.AlunoViewModel;

public interface AlunoFacadeInterface {

    AlunoViewModel obterPorId(UUID id);
    List<AlunoViewModel> obterTodos();
    void salvar(AlunoViewModel aluno);
}