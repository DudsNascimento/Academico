package com.academico.application.facade;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.modelmapper.ModelMapper;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.academico.infrastructure.exception.BusinessException;
import com.academico.application.viewmodel.LoginViewModel;

public class LoginFacade implements LoginFacadeInterface {

    @Value("${login.url}")
	private String loginUrl;

    @Value("${keycloak.resource}")
	private String clientId;

    @Inject
    private ModelMapper modelMapper;

    public LoginViewModel logar(LoginViewModel login) {

        try {

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("grant_type", "password");
            map.add("client_id", clientId);
            map.add("username", login.getUsername());
            map.add("password", login.getPassword());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForObject(loginUrl, request, LoginViewModel.class);             

        } catch (HttpClientErrorException.Unauthorized e) {
            throw new BusinessException("Erro de autenticação: usuário ou senha incorretos");
        }
    }
}