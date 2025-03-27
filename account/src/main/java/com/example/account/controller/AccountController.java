package com.example.account.controller;


import com.example.account.dto.CardDTO;
import com.example.account.dto.CustomerDto;
import com.example.account.dto.ResponseData;
import com.example.account.service.AccountService;
import com.example.account.service.CardClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CardClient cardClient;


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

    @GetMapping("/account/cards")
    public List<CardDTO> getAccountCards() {
        // This call is automatically translated to an HTTP GET call to card-service at /cards/{accountId}
        return cardClient.getCardsForAccount();
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "Account Service");
        return ResponseEntity.ok(response);
    }
}
