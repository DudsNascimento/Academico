package com.custom

import java.io.File
import com.google.common.base.CaseFormat;
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input

open class AddControllerTask: DefaultTask() {

    @Input
    lateinit var classpath: String;

    @TaskAction
    fun addController() {

        println("Qual o nome do seu controller (e.g Aluno)? ")
        var controller: String? = readLine()
        println("Criando estrutura para controller $controller no classpath $classpath")

        this.addControllerClass(controller);
        this.addFacadeInterfaceClass(controller);
        this.addFacadeClass(controller);
        this.addFacadeConfigurationClass(controller);
    }

    private fun addControllerClass(controller: String?) {
        var endpoint: String = "";
        controller?.let{
            endpoint = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, it);
        };
        File("${this.classpath}/application/controller/${controller}Controller.java").writeText(
            """package com.academico.application.controller;

            #import java.util.List;
            #import java.lang.SuppressWarnings;
            #import org.springframework.web.bind.annotation.RestController;
            #import org.springframework.http.ResponseEntity;
            #import org.springframework.web.bind.annotation.RequestMapping;
            #import org.springframework.web.bind.annotation.RequestMethod;
            #import org.springframework.web.bind.annotation.RequestBody;
            #import org.springframework.web.bind.annotation.ResponseBody;
            #import org.springframework.http.HttpStatus;
            #import com.academico.application.facade.${controller}FacadeInterface;
            #import com.academico.infrastructure.response.ControllerResponse;

            #@RestController
            #@RequestMapping(value = "/${endpoint}")
            #public class ${controller}Controller {

            #    ${controller}FacadeInterface ${controller?.decapitalize()}Facade;

            #    public ${controller}Controller(${controller}FacadeInterface ${controller?.decapitalize()}Facade) {
            #        this.${controller?.decapitalize()}Facade = ${controller?.decapitalize()}Facade;
            #    }
            #}""".trimMargin("#"))
    }

    private fun addFacadeInterfaceClass(controller: String?) {
        File("${this.classpath}/application/facade/${controller}FacadeInterface.java").writeText(
            """package com.academico.application.facade;

            #import java.util.UUID;
            #import java.util.List;

            #public interface ${controller}FacadeInterface {
            #}""".trimMargin("#"))
    }

    private fun addFacadeClass(controller: String?) {
        File("${this.classpath}/application/facade/${controller}Facade.java").writeText(
            """package com.academico.application.facade;

            #import java.util.UUID;
            #import java.util.List;
            #import java.util.stream.Collectors;
            #import javax.inject.Inject;
            #import org.modelmapper.ModelMapper;
            #import org.springframework.transaction.annotation.Transactional;
            #import org.springframework.transaction.annotation.Propagation;
            #import org.springframework.transaction.annotation.Isolation;
            #import com.academico.infrastructure.exception.InternalErrorException;

            #public class ${controller}Facade implements ${controller}FacadeInterface {

            #    @Inject
            #    private ModelMapper modelMapper;
            #}""".trimMargin("#"))
    }

    private fun addFacadeConfigurationClass(controller: String?) {
        File("${this.classpath}/infrastructure/configuration/facade/${controller}FacadeConfiguration.java").writeText(
            """package com.academico.infrastructure.configuration.facade;

            #import org.springframework.context.annotation.Configuration;
            #import org.springframework.context.annotation.Bean;
            #import com.academico.application.facade.${controller}Facade;
            #import com.academico.application.facade.${controller}FacadeInterface;

            #@Configuration
            #public class ${controller}FacadeConfiguration {

            #    @Bean
            #    public ${controller}FacadeInterface ${controller?.decapitalize()}Facade() {

            #        ${controller}FacadeInterface ${controller?.decapitalize()}Facade = new ${controller}Facade();
            #        return ${controller?.decapitalize()}Facade;
            #    }
            #}""".trimMargin("#"))
    }
}