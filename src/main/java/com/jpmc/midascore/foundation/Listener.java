package com.jpmc.midascore.foundation;

import com.jpmc.midascore.service.TransactionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.String.*;
@Component
public class Listener {
    private TransactionService transactionService;

    public Listener(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @KafkaListener(id ="foo", topics = "${general.kafka-topic}")
    public void listen(Transaction transaction) {
        transactionService.processTransaction(transaction);
    }



}
