package com.example.card.mapper;

import com.example.card.dto.CardDto;
import com.example.card.entity.Card;

public class CardMapper {

    public static Card toCard(CardDto cardDto, Card card) {
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardHolder(cardDto.getCardHolder());
        card.setCvv(cardDto.getCvv());
        card.setExpireMonth(cardDto.getExpireMonth());
        card.setExpireYear(cardDto.getExpireYear());
        card.setCardType(cardDto.getCardType());
        card.setAccountNumber(cardDto.getAccountNumber());
        return card;
    }

    public static CardDto toCardDto(Card card) {
        return new CardDto.Builder()
                .cardNumber(card.getCardNumber())
                .cardHolder(card.getCardHolder())
                .cvv(card.getCvv())
                .expireMonth(card.getExpireMonth())
                .expireMonth(card.getExpireYear())
                .cardType(card.getCardType())
                .accountNumber(card.getAccountNumber())
                .build();
    }
}
