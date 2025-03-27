package com.example.account.mapper;


import com.example.account.dto.AccountDto;
import com.example.account.entity.Account;

public class AccountMapper {

    public static AccountDto accountToAccountDto(com.example.account.entity.Account account, AccountDto accountDto) {
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setBranchName(account.getBranchName());
        accountDto.setBranchCode(account.getBranchCode());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setAccountHolderName(account.getAccountHolderName());
        accountDto.setBalance(account.getBalance());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }

    public static Account accountDtoToAccount(AccountDto accountDto, com.example.account.entity.Account account) {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBranchName(accountDto.getBranchName());
        account.setBranchCode(accountDto.getBranchCode());
        account.setAccountType(accountDto.getAccountType());
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setBalance(accountDto.getBalance());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
