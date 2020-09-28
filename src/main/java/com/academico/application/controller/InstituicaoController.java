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
import com.academico.application.facade.InstituicaoFacadeInterface;
import com.academico.infrastructure.response.ControllerResponse;

@RestController
@RequestMapping(value = "/instituicao")
public class InstituicaoController {

    InstituicaoFacadeInterface instituicaoFacade;

    public InstituicaoController(InstituicaoFacadeInterface instituicaoFacade) {
        this.instituicaoFacade = instituicaoFacade;
    }
}