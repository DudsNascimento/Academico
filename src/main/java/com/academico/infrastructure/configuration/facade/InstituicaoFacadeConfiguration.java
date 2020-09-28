package com.academico.infrastructure.configuration.facade;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.academico.application.facade.InstituicaoFacade;
import com.academico.application.facade.InstituicaoFacadeInterface;

@Configuration
public class InstituicaoFacadeConfiguration {

    @Bean
    public InstituicaoFacadeInterface instituicaoFacade() {

        InstituicaoFacadeInterface instituicaoFacade = new InstituicaoFacade();
        return instituicaoFacade;
    }
}