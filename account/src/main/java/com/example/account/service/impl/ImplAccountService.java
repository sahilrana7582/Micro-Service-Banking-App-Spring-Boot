package com.example.account.service.impl;

import com.example.account.dto.CardDTO;
import com.example.account.dto.CustomerDto;
import com.example.account.dto.ResponseData;
import com.example.account.entity.Account;
import com.example.account.entity.Customer;
import com.example.account.mapper.CustomerMapper;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.CustomerRepository;
import com.example.account.service.AccountService;
import com.example.account.service.CardClient;
import com.example.account.service.event.AccountCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImplAccountService implements AccountService {


    @Autowired
    private final KafkaTemplate<String, Object> kafkaTemplate;


    @Value("${kafka.topic.account-created}")
    private String accountCreatedTopic;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardClient cardClient;


    @Override
    public void createAccount(CustomerDto customerDto) {
        // Map the incoming DTO to a Customer entity
        Customer newCustomer = CustomerMapper.customerDtoToCustomer(customerDto, new Customer());
        Customer savedCustomer = customerRepository.save(newCustomer);

        // Create and save the account for the customer
        Account createdAccount = createAccount(savedCustomer);

        AccountCreatedEvent event = new AccountCreatedEvent(createdAccount.getAccountNumber(), createdAccount.getAccountHolderName());
        publishAccountCreatedEvent(event);
    }

    private Account createAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getId());
        Long randomAccountNumber = Math.round(Math.random() * 1000000000L);
        newAccount.setAccountNumber(String.valueOf(randomAccountNumber));
        newAccount.setAccountType("SAVING");
        newAccount.setAccountHolderName(customer.getFirstName() + " " + customer.getLastName());
        newAccount.setBalance(0.0);
        newAccount.setBranchCode("001");
        newAccount.setBranchName("Main Branch");
        newAccount.setBranchAddress("Main Branch Address, New Delhi, India");
        Account createdAccount = accountRepository.save(newAccount);



        return createdAccount;
    }

    private String generateRandomCardNumber() {
        // Generate a dummy 16-digit card number
        long number = (long) (Math.random() * 1_0000_0000_0000_0000L);
        return String.format("%016d", number);
    }
    public void publishAccountCreatedEvent(AccountCreatedEvent event) {
        System.out.println("Account created event: <<<<<<<<");

        // Create a ProducerRecord with headers
        ProducerRecord<String, Object> record = new ProducerRecord<>(
                accountCreatedTopic,
                event.getAccountId().toString(),
                event
        );

        // Add type information to the headers
        record.headers().add(new RecordHeader("event-type", event.getClass().getName().getBytes(StandardCharsets.UTF_8)));

        // Send the message with headers
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(record);

        future.thenAccept(result -> {
            log.info("Event sent successfully to topic: {}, partition: {}, offset: {}",
                    result.getRecordMetadata().topic(),
                    result.getRecordMetadata().partition(),
                    result.getRecordMetadata().offset());
        }).exceptionally(ex -> {
            log.error("Failed to send event to Kafka", ex);
            return null;
        });
    }
}
