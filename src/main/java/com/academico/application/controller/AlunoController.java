package com.academico.application.controller;

import java.util.List;
import java.lang.SuppressWarnings;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import com.academico.application.facade.AlunoFacadeInterface;
import com.academico.application.viewmodel.AlunoViewModel;
import com.academico.infrastructure.response.ControllerResponse;
import com.academico.infrastructure.configuration.jwt.WithAnyOfTheseRoles;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

    AlunoFacadeInterface alunoFacade;

    public AlunoController(AlunoFacadeInterface alunoFacade) {
        this.alunoFacade = alunoFacade;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @WithAnyOfTheseRoles(roles = {"consulta-aluno", "gerencia-aluno"})
    public ResponseEntity obter() {

        return new ResponseEntity(new ControllerResponse(this.alunoFacade.obterTodos()), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @WithAnyOfTheseRoles(roles = "gerencia-aluno")
    public ResponseEntity salvar(@RequestBody AlunoViewModel aluno) {

        this.alunoFacade.salvar(aluno);
        return new ResponseEntity(HttpStatus.OK);
    }
}