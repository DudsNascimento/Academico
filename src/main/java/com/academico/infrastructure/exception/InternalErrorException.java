package com.academico.infrastructure.exception;

import java.lang.RuntimeException;

public class InternalErrorException extends RuntimeException { 

    public InternalErrorException(String message) {
        super(message);
    }
}