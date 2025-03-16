package com.example.account.dto;


import com.example.account.entity.Customer;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String accountNumber;

    private String branchName;

    private String branchCode;

    private String accountType;

    private String accountHolderName;

    private Double balance;

    private String branchAddress;
}
