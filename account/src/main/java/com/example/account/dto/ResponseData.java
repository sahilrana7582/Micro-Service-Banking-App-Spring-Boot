package com.example.account.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data @AllArgsConstructor
public class ResponseData {
    private HttpStatus statusCode;
    private String statusMessage;
}
