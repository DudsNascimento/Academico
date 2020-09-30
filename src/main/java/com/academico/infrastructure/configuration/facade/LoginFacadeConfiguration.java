package com.academico.infrastructure.configuration.facade;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.academico.application.facade.LoginFacade;
import com.academico.application.facade.LoginFacadeInterface;

@Configuration
public class LoginFacadeConfiguration {

    @Bean
    public LoginFacadeInterface loginFacade() {

        LoginFacadeInterface loginFacade = new LoginFacade();
        return loginFacade;
    }
}