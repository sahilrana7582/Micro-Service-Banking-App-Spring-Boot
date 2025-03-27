package com.example.account.service;


import com.example.account.dto.CardDTO;
import com.example.account.dto.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "card-service")
public interface CardClient {
    @GetMapping("/api/card/cards")
    List<CardDTO> getCardsForAccount();

    @PostMapping("/api/card/saveCard")
    ResponseEntity<ResponseData> createCard(@RequestBody CardDTO cardDTO);
}
