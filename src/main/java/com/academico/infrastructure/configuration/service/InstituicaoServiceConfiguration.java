package com.academico.infrastructure.configuration.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.academico.domain.service.InstituicaoService;
import com.academico.domain.service.InstituicaoServiceInterface;

@Configuration
public class InstituicaoServiceConfiguration {

    @Bean
    public InstituicaoServiceInterface instituicaoService() {

        InstituicaoServiceInterface instituicaoService = new InstituicaoService();
        return instituicaoService;
    }
}