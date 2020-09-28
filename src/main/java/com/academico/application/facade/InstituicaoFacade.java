package com.academico.application.facade;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;
import com.academico.infrastructure.exception.InternalErrorException;

public class InstituicaoFacade implements InstituicaoFacadeInterface {

    @Inject
    private ModelMapper modelMapper;
}