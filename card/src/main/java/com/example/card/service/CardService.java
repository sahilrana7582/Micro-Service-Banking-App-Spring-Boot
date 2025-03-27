package com.example.card.service;


import com.example.card.dto.CardDto;
import com.example.card.entity.Card;
import com.example.card.mapper.CardMapper;
import com.example.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;



    public Card saveCard(CardDto cardDto) {
        Card card = CardMapper.toCard(cardDto, new Card());
        return cardRepository.save(card);
    }

    public Card createCard(UUID accountId, String accountName, String accountNumber) {

        CardDto cardDTO = new CardDto.Builder()
                .cardHolder(accountName)
                .accountNumber(accountNumber)
                .cardType("DEBIT-VISA")
                .cardNumber(generateCardNumber())
                .expireYear("2030")
                .expireMonth("12")
                .build();


        Card card = CardMapper.toCard(cardDTO, new Card());
        return cardRepository.save(card);

    }


    private String generateCardNumber() {
        long number = (long) (Math.random() * 1_0000_0000_0000_0000L);
        String cardNumber = String.format("%016d", number); // Ensure 16-digit format
        return cardNumber.replaceAll("(.{4})", "$1 "); // Add space every 4 characters
    }


    public List<Card> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        return cards;
    }
}
