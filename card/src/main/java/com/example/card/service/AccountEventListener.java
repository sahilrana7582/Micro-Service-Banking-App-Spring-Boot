package com.example.card.service;

import com.example.card.entity.Card;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccountEventListener {

    @Autowired
    private CardService cardService;

    @KafkaListener(topics = "${kafka.topic.account-created}", groupId = "card-service-group")
    public void handleAccountCreated(AccountCreatedEvent receivedEvent) {
        System.out.println("Event Received: " + receivedEvent);
        try {
            // Since Spring Kafka is configured to deserialize the message,
            // the receivedEvent is already an AccountCreatedEvent object.
            Card card = cardService.createCard(receivedEvent.getAccountId(), receivedEvent.getAccountName(), receivedEvent.getAccountNumber());
            log.info("Successfully created card for account: {}, card details: {}",
                    receivedEvent.getAccountId(), card);
        } catch (Exception e) {
            log.error("Error processing AccountCreatedEvent: {}", receivedEvent, e);
        }
    }
}
