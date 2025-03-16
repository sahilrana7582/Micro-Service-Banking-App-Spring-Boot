package com.example.account.dto;


import lombok.*;

@Setter
@Getter
 @NoArgsConstructor
@Data @AllArgsConstructor
public class CustomerDto {

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    private String username;

    private int age;
}
