package com.example.card.dto;


import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseDto {

    private HttpStatus status;
    private String message;
}
