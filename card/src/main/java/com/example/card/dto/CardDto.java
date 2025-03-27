package com.example.card.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

@Data
@Getter
@JsonDeserialize(builder = CardDto.Builder.class)
public class CardDto {

    private final String cardNumber;

    private final String cardHolder;

    private final String expireMonth;

    private final String expireYear;

    private final String cvv;

    private final String cardType;

    private final String accountNumber;

    private CardDto(Builder builder) {
        this.cardNumber = builder.cardNumber;
        this.cardHolder = builder.cardHolder;
        this.expireMonth = builder.expireMonth;
        this.expireYear = builder.expireYear;
        this.cvv = builder.cvv;
        this.cardType = builder.cardType;
        this.accountNumber = builder.accountNumber;
    }


    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private String cardNumber;
        private String cardHolder;
        private String expireMonth;
        private String expireYear;
        private String cvv;
        private String cardType;
        private String accountNumber;

        public Builder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder cardHolder(String cardHolder) {
            this.cardHolder = cardHolder;
            return this;
        }

        public Builder expireMonth(String expireMonth) {
            this.expireMonth = expireMonth;
            return this;
        }

        public Builder expireYear(String expireYear) {
            this.expireYear = expireYear;
            return this;
        }

        public Builder cvv(String cvv) {
            this.cvv = cvv;
            return this;
        }

        public Builder cardType(String cardType){
            this.cardType = cardType;
            return this;
        }

        public Builder accountNumber(String accountNumber){
            this.accountNumber = accountNumber;
            return this;
        }


        public CardDto build() {
            return new CardDto(this);
        }
    }
}
