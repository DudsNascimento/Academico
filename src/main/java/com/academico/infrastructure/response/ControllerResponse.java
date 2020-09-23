package com.academico.infrastructure.response;

public class ControllerResponse<T> {

    private T data;

    public ControllerResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}