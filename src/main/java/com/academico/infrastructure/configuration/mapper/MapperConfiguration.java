package com.academico.infrastructure.configuration.mapper;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}