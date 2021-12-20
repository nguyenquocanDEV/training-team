package com.example.demo.dtos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRes<T> {
    private List<T> data;
    private Pages pages;
    private String message;
    private HttpStatus status;
}
