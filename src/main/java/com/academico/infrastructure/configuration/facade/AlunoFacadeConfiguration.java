package com.academico.infrastructure.configuration.facade;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.academico.application.facade.AlunoFacade;
import com.academico.application.facade.AlunoFacadeInterface;
import com.academico.domain.service.AlunoServiceInterface;
import com.academico.infrastructure.configuration.service.AlunoServiceConfiguration;

@Configuration
public class AlunoFacadeConfiguration {

    @Bean
    public AlunoFacadeInterface alunoFacade() {

        AlunoFacadeInterface alunoFacade = new AlunoFacade();
        return alunoFacade;
    }
}