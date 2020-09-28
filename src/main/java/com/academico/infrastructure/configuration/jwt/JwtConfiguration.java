package com.academico.infrastructure.configuration.jwt;

import java.lang.Class;
import java.lang.ClassLoader;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.util.Set;
import org.reflections.Reflections;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;

@Configuration
@EnableWebSecurity   
class JwtConfiguration extends KeycloakWebSecurityConfigurerAdapter {
    
    @Autowired
    public void configureGlobal(
        AuthenticationManagerBuilder auth) throws Exception {
    
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }
    
    @Bean
    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
    
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(
            new SessionRegistryImpl());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        super.configure(http);
        ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http.csrf().disable().authorizeRequests();
        
        for(ClassPath.ClassInfo classInfo : ClassPath.from(JwtConfiguration.class.getClassLoader()).getTopLevelClasses("com.academico.application.controller")) {
            Class controller = JwtConfiguration.class.getClassLoader().loadClass(classInfo.getName());
            String endpointPrefix = "";
            for(Annotation annotation : controller.getAnnotations()) {
                if(annotation.annotationType().getName().equals("org.springframework.web.bind.annotation.RequestMapping")) {
                    endpointPrefix = ((String[])annotation.annotationType().getMethod("value").invoke(annotation))[0].toString();
                }
            }
            for(Method method : controller.getMethods()) {
                String[] roles = null;
                RequestMethod requestMethod = null;
                String endpoint = null;
                for(Annotation annotation : method.getAnnotations()) {
                    if(annotation.annotationType().getName().equals("com.academico.infrastructure.configuration.jwt.WithAnyOfTheseRoles")) {
                        roles = (String[])(annotation.annotationType().getMethod("roles").invoke(annotation));
                    } else if(annotation.annotationType().getName().equals("org.springframework.web.bind.annotation.RequestMapping")) {
                        requestMethod = ((RequestMethod[])(annotation.annotationType().getMethod("method").invoke(annotation)))[0];
                        endpoint = ((String[])(annotation.annotationType().getMethod("value").invoke(annotation)))[0];
                    }
                }

                if(roles != null && requestMethod != null && endpointPrefix != null && endpoint != null) {
                    HttpMethod httpMethod;
                    if(RequestMethod.GET.equals(requestMethod)) {
                        httpMethod = HttpMethod.GET;
                    } else if(RequestMethod.POST.equals(requestMethod)) {
                        httpMethod = HttpMethod.POST;
                    } else if(RequestMethod.PUT.equals(requestMethod)) {
                        httpMethod = HttpMethod.PUT;
                    } else if(RequestMethod.DELETE.equals(requestMethod)) {
                        httpMethod = HttpMethod.DELETE;
                    } else {
                        httpMethod = HttpMethod.GET;
                    }
                    expressionInterceptUrlRegistry = ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)expressionInterceptUrlRegistry
                        .antMatchers(httpMethod, endpointPrefix+endpoint))
                        .hasAnyRole(roles);
                }
            }
        }      
        ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)expressionInterceptUrlRegistry.anyRequest()).permitAll();
    }
}