package com.example.account.dto;


import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private HttpStatus statusCode;
    private String statusMessage;
}
