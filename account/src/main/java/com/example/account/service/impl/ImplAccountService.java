package com.example.account.service.impl;

import com.example.account.dto.CustomerDto;
import com.example.account.entity.Account;
import com.example.account.entity.Customer;
import com.example.account.exception.CustomerAlreadyExistException;
import com.example.account.mapper.CustomerMapper;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.CustomerRepository;
import com.example.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class ImplAccountService implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer newCustomer = CustomerMapper.customerDtoToCustomer(customerDto, new Customer());
        Customer savedCustoemer = customerRepository.save(newCustomer);
        Account newAccount = createAccount(savedCustoemer);
        accountRepository.save(newAccount);
    }

    private Account createAccount(Customer customer){
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getId());
        Long randomAccountNumber = Math.round(Math.random() * 1000000000L);
        newAccount.setAccountNumber(String.valueOf(randomAccountNumber));
        newAccount.setAccountType("SAVING");
        newAccount.setAccountHolderName(customer.getFirstName() + " " + customer.getLastName());
        newAccount.setBalance(0.0);
        newAccount.setBranchCode("001");
        newAccount.setBranchName("Main Branch");
        newAccount.setBranchAddress("Main Branch Address, New Delhi, India");
        return accountRepository.save(newAccount);
    }
}
