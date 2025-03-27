package com.example.card.controller;

import com.example.card.dto.CardDto;
import com.example.card.dto.ResponseDto;
import com.example.card.entity.Card;
import com.example.card.service.CardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/card", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/saveCard")
    public ResponseEntity<ResponseDto> saveCard(@RequestBody CardDto cardDto) {
        cardService.saveCard(cardDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED, "Card saved successfully"));
    }

    @GetMapping("/cards")
    public List<Card> getCardsForAccount() {
        return cardService.getAllCards();
    }

    @GetMapping("/portInfo")
    public String getPortInfo(HttpServletRequest request) {
        int port = request.getLocalPort();
        int serverPort = request.getServerPort();

        return "Port: " + port + ", Server Port: " + serverPort;
    }


}
