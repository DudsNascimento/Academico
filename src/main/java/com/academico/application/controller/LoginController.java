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
import com.academico.application.facade.LoginFacadeInterface;
import com.academico.infrastructure.response.ControllerResponse;
import com.academico.application.viewmodel.LoginViewModel;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    LoginFacadeInterface loginFacade;

    public LoginController(LoginFacadeInterface loginFacade) {
        this.loginFacade = loginFacade;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity salvar(@RequestBody LoginViewModel login) {

        return new ResponseEntity(this.loginFacade.logar(login), HttpStatus.OK);
    }
}