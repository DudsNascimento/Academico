package com.custom

import java.io.File
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input

open class AddEntityTask: DefaultTask() {

    @Input
    lateinit var classpath: String;

    @TaskAction
    fun addEntity() {

        println("Qual o nome da sua entidade (e.g Aluno)? ")
        var entidade: String? = readLine()
        println("Criando estrutura para entidade $entidade no classpath $classpath")

        this.addEntityClass(entidade);
        this.addRepositoryInterfaceClass(entidade);
        this.addServiceInterfaceClass(entidade);
        this.addServiceClass(entidade);
        this.addValidatorClass(entidade);
        this.addServiceConfigurationClass(entidade);
        this.addValidatorConfigurationClass(entidade);
    }

    private fun addEntityClass(entidade: String?) {
        File("${this.classpath}/domain/entity/${entidade}.java").writeText(
            """package com.academico.domain.entity;

            #import java.util.UUID;
            #import java.util.Date;
            #import javax.persistence.Entity;
            #import javax.persistence.Column;

            #@Entity
            #public class ${entidade} extends BaseEntity {
            #}""".trimMargin("#"))
    }

    private fun addRepositoryInterfaceClass(entidade: String?) {
        File("${this.classpath}/domain/repository/${entidade}RepositoryInterface.java").writeText(
            """package com.academico.domain.repository;

            #import java.util.UUID;
            #import java.util.Optional;
            #import org.springframework.stereotype.Repository;
            #import com.academico.domain.entity.${entidade};
            #import com.academico.domain.repository.BaseRepositoryInterface;

            #@Repository
            #public interface ${entidade}RepositoryInterface extends BaseRepositoryInterface<${entidade}> {

            #}""".trimMargin("#"))
    }

    private fun addServiceInterfaceClass(entidade: String?) {
        File("${this.classpath}/domain/service/${entidade}ServiceInterface.java").writeText(
            """package com.academico.domain.service;

            #import com.academico.domain.entity.${entidade};

            #public interface ${entidade}ServiceInterface extends BaseServiceInterface<${entidade}> {
            #}""".trimMargin("#"))
    }

    private fun addServiceClass(entidade: String?) {
        File("${this.classpath}/domain/service/${entidade}Service.java").writeText(
            """package com.academico.domain.service;

            #import org.springframework.beans.factory.annotation.Autowired;
            #import com.academico.domain.entity.${entidade};
            #import com.academico.domain.repository.BaseRepositoryInterface;
            #import com.academico.domain.repository.${entidade}RepositoryInterface;
            #import com.academico.domain.validator.BaseValidatorInterface;

            #public class ${entidade}Service extends BaseService<${entidade}> implements ${entidade}ServiceInterface {

            #    @Autowired
            #    public ${entidade}RepositoryInterface ${entidade?.decapitalize()}Repository;

            #    @Autowired
            #    public BaseValidatorInterface<${entidade}> ${entidade?.decapitalize()}Validator;

            #    @Override
            #    protected BaseRepositoryInterface<${entidade}> getBaseRepository() {
            #        return this.${entidade?.decapitalize()}Repository;
            #    }

            #    @Override
            #    protected BaseValidatorInterface<${entidade}> getBaseValidator() {
            #        return this.${entidade?.decapitalize()}Validator;
            #    }
            #}""".trimMargin("#"))
    }

    private fun addValidatorClass(entidade: String?) {
        File("${this.classpath}/domain/validator/${entidade}Validator.java").writeText(
            """package com.academico.domain.validator;

            #import org.springframework.beans.factory.annotation.Autowired;
            #import com.academico.domain.entity.BaseEntity;
            #import com.academico.domain.entity.${entidade};
            #import com.academico.domain.repository.${entidade}RepositoryInterface;
            #import com.academico.infrastructure.exception.BusinessException;

            #public class ${entidade}Validator implements BaseValidatorInterface<${entidade}> {

            #    @Autowired
            #    public ${entidade}RepositoryInterface ${entidade?.decapitalize()}Repository;

            #    public void validateCreate(${entidade} entity) {
            #    }

            #    public void validateUpdate(${entidade} entity) {
            #    }
            #}""".trimMargin("#"))
    }

    private fun addServiceConfigurationClass(entidade: String?) {
        File("${this.classpath}/infrastructure/configuration/service/${entidade}ServiceConfiguration.java").writeText(
            """package com.academico.infrastructure.configuration.service;

            #import org.springframework.context.annotation.Configuration;
            #import org.springframework.context.annotation.Bean;
            #import com.academico.domain.service.${entidade}Service;
            #import com.academico.domain.service.${entidade}ServiceInterface;

            #@Configuration
            #public class ${entidade}ServiceConfiguration {

            #    @Bean
            #    public ${entidade}ServiceInterface ${entidade?.decapitalize()}Service() {

            #        ${entidade}ServiceInterface ${entidade?.decapitalize()}Service = new ${entidade}Service();
            #        return ${entidade?.decapitalize()}Service;
            #    }
            #}""".trimMargin("#"))
    }

    private fun addValidatorConfigurationClass(entidade: String?) {
        var texto: String = File("${this.classpath}/infrastructure/configuration/validator/BaseValidatorConfiguration.java")
            .readText(Charsets.UTF_8)
            .replace("\n@Configuration", """
            #import com.academico.domain.validator.${entidade}Validator;

            #@Configuration""".trimMargin("#"))
            .replace("\n}", """


                #    @Bean
                #    public BaseValidatorInterface ${entidade?.decapitalize()}Validator() {

                #        ${entidade}Validator validator = new ${entidade}Validator();
                #        return validator;
                #    }
                #}""".trimMargin("#"))

        File("${this.classpath}/infrastructure/configuration/validator/BaseValidatorConfiguration.java").writeText(texto)
    }
}