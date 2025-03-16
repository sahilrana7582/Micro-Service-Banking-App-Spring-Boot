package com.example.account.controller;


import com.example.account.dto.CustomerDto;
import com.example.account.dto.ResponseData;
import com.example.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping
    public String getAccount() {
        return "account";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseData> createAccount(@RequestBody CustomerDto customerDto) {
        accountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseData(HttpStatus.CREATED, "Account created successfully"));
    }
}
