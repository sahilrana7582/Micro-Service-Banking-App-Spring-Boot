package com.example.account.dto;


import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

    private String cardNumber;
    private String cardHolder;
    private String expireMonth;
    private String expireYear;
    private String cvv;
    private String cardType;
    private String accountNumber;
}
