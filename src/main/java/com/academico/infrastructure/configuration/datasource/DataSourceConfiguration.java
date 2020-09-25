package com.academico.infrastructure.configuration.datasource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class DataSourceConfiguration {
	    
    @Bean
    public DataSource getDataSource() {
    
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceBuilder.url("jdbc:sqlserver://localhost;databaseName=Academico");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("Q1w2e3r4t5*");
        return dataSourceBuilder.build();
    }
}