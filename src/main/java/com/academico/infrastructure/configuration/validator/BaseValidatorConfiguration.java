package com.academico.infrastructure.configuration.validator;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.academico.domain.validator.BaseValidatorInterface;
import com.academico.domain.validator.AlunoValidator;

@Configuration
public class BaseValidatorConfiguration {

    @Bean
    public BaseValidatorInterface alunoValidator() {

        AlunoValidator validator = new AlunoValidator();
        return validator;
    }
}