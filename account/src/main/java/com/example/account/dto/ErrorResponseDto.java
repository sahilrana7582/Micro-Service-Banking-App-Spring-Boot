package com.example.account.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDto {

    private String apiPath;
    private String errorCode;
    private String errorMessage;
    private LocalDateTime errorTime;

}
