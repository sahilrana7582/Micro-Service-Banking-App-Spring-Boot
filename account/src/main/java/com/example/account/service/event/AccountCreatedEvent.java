package com.example.account.service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedEvent implements Serializable {

    private UUID eventId;

    private UUID accountId;

    private String accountName;

    private String accountNumber;


    public AccountCreatedEvent(String accountNumber, String accountName) {
        this.eventId = UUID.randomUUID();
        this.accountId = UUID.randomUUID();
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "AccountCreatedEvent{" +
                "eventId=" + eventId +
                ", accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

}
