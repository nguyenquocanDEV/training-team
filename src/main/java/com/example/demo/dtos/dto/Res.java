package com.example.demo.dtos.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Res<T> {
    private T data;
    private String message;
    private HttpStatus status;

    public Res(T data, String message, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Res(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
