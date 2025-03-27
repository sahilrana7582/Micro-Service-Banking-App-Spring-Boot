package com.example.card.service;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Event representing the creation of a new account.
 * This is a shared model between Account Service (producer) and Card Service (consumer).
 * The package structure must match what's configured in the trusted packages property.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedEvent implements Serializable {

    // A unique identifier for each event instance
    private UUID eventId;

    // The unique identifier for the created account
    private UUID accountId;

    // The name associated with the created account
    private String accountName;

    // The email address associated with the created account
    private String accountNumber;

}