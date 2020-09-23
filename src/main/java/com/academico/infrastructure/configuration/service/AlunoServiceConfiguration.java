package com.academico.infrastructure.configuration.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.academico.domain.service.AlunoService;
import com.academico.domain.service.AlunoServiceInterface;

@Configuration
public class AlunoServiceConfiguration {

    @Bean
    public AlunoServiceInterface alunoService() {

        AlunoServiceInterface alunoService = new AlunoService();
        return alunoService;
    }
}